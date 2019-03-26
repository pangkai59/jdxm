package com.jdxm.utils;

import com.jdxm.common.constant.StatusConstant;
import com.jdxm.common.exception.CodeRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数值相关
 *
 * @author dyf
 */

public class MathUtils {

    private static Logger logger = LoggerFactory.getLogger(MathUtils.class);

    /**
     * 保留两位小数
     *
     * @param num 小数
     * @return double
     */
    public static double formatNumber(double num) {

        BigDecimal bg = new BigDecimal(num).setScale(2, RoundingMode.DOWN); //不需要四舍五入

        return bg.doubleValue();
    }


    /**
     * 保留两位小数(需要四舍五入)
     *
     * @param num 小数
     * @return double
     */
    public static double formatNumberRound(double num, int precision) {

        //需要四舍五入
        BigDecimal bg = new BigDecimal(num).setScale(precision, RoundingMode.UP);

        return bg.doubleValue();
    }


    /**
     * 保留小数位数
     *
     * @param num       数字
     * @param precision 精确到小数点后面的位数
     * @return double
     */
    public static double formatNumber(double num, int precision) {

        BigDecimal bg = new BigDecimal(num).setScale(precision, RoundingMode.DOWN); //不需要四舍五入

        return bg.doubleValue();
    }

    /**
     * 保留小数位数 四舍五入版
     *
     * @param num
     * @param precision
     * @return
     */
    public static double formatNumberHalfUp(double num, int precision) {

        BigDecimal bg = new BigDecimal(num).setScale(precision, RoundingMode.HALF_UP); //不需要四舍五入

        return bg.doubleValue();
    }


    /**
     * js计算引擎，返回double(这个版本已经过时了，只能计算简单的表达式)
     */
    public static Double jsScriptEngine(String expression) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        return (Double) se.eval(expression);
    }

//    /**
//     * js计算引擎(这个版本可以使用所有控制语句)
//     * @param expression eg. "if(true){ return {Account}*0.4; } else {return 0}"
//     */
//    public static Double jsScriptEngine(String expression) throws ScriptException {
//
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("js");
//
//        //expression = "if(1 == 1){return 1;} return 2;";
//
//        String func = "function feeMoneyCalculator(){ EXPRESSION }";
//
//        //将用户自定义的表达式替换到func中
//        func = func.replace("EXPRESSION", expression);
//
//        System.out.println(func);
//
//        engine.eval(func);
//
//        String resultFormula = "var feeMoney= feeMoneyCalculator();";
//
//        engine.eval(resultFormula);
//
//        return (Double) engine.get("feeMoney");
//    }


    /**
     * 根据给定计算公式计算值
     *
     * @param formula 公式 eg. "0.4*{account}*{BorrowPeriod}"
     * @param object  数据源对象
     * @return 计算结果
     * @throws Exception 异常
     */
    public static Double formulaCalculator(String formula, Object object) throws Exception {
        Pattern pattern = Pattern.compile("\\{#([a-zA-Z0-9]*)#\\}");
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            String ss = matcher.group(); //需要替换的字符串

            String fieldName = ss.substring(2, ss.length() - 2);

            Class clazz = object.getClass();
            String methodName = "get" + fieldName;
            Method method = clazz.getDeclaredMethod(methodName);
            //判断这个方法的返回值，只接收Integer,Double,Float这三种类型的参数
            if (!method.getReturnType().equals(Integer.class) && !method.getReturnType().equals(Double.class)
                    && !method.getReturnType().equals(Float.class)) {
                throw new Exception("公式参数类型错误");
            }


            //Double value = Double.parseDouble(method.invoke(object).toString());
            //String valueStr = value.toString();
            String valueStr = method.invoke(object).toString();

            //进行替换
            formula = formula.replace(ss, valueStr);
        }

        System.out.println(formula);
        return MathUtils.jsScriptEngine(formula);
    }

    /**
     * 根据给定计算公式计算值
     *
     * @param formula 公式 eg. "0.4*{}*{Account}*{BorrowPeriod}"  money的占位字符串为 FEEMONEY
     * @param object  数据源对象
     * @return 计算结果
     * @throws Exception 异常
     */
    public static BigDecimal formulaCalculator(String formula, Object object, BigDecimal money) throws Exception {
        logger.info(String.format("开始计算公式 formula[%s] money[%f]", formula, money));
        //首先，先将money字段替换
        formula = formula.replaceAll("\\{#FEEMONEY#\\}", money.toString());
        logger.info(String.format("替换FEEMONEY之后 [%s]", formula));

        Pattern pattern = Pattern.compile("\\{#([a-zA-Z0-9]*)#\\}");
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            String ss = matcher.group(); //需要替换的字符串
            logger.info(String.format(" -> 替换[%s]", ss));

            String fieldName = ss.substring(2, ss.length() - 2);

            Class clazz = object.getClass();
            String methodName = "get" + fieldName;
            Method method = clazz.getDeclaredMethod(methodName);
            //判断这个方法的返回值，只接收Integer,Double,Float这三种类型的参数
            if (!method.getReturnType().equals(Integer.class) && !method.getReturnType().equals(Double.class)
                    && !method.getReturnType().equals(Float.class)) {
                throw new CodeRuntimeException(StatusConstant.ERR, "公式参数类型错误");
            }

            String valueStr = method.invoke(object).toString();
            logger.info(String.format(" -> 为[%s]", valueStr));
            //进行替换
            formula = formula.replace(ss, valueStr);
            logger.info(String.format(" -> 现在的公式[%s]", formula));
        }

        logger.info(String.format("最终的公式[%s]", formula));
        Double result = (Double) MathUtils.jsScriptEngine(formula) * 1.0;
        logger.info(String.format("result[%f]", result));

        // 当公式没有返回值时，最后结果会是null，这里把这种视为预期内的行为，以0返回
        return new BigDecimal(result);
    }


    /**
     * 加法运算
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(Double value1, Double value2) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.add(b2).doubleValue();
    }


    /**
     * 不定参数加法
     *
     * @param value1   加数
     * @param value2   被加数
     * @param valueArg 多个被加数
     * @return 多个参数的和
     */
    public static double add(Double value1, Double value2, Double... valueArg) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());

        double b = b1.add(b2).doubleValue();
        if (valueArg.length == 0) {
            return b;
        }
        for (Double item : valueArg) {
            b = add(b, item);
        }
        return b;
    }


    /**
     * 减法运算
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static double sub(Double value1, Double value2) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.subtract(b2).doubleValue();
    }


    /**
     * 乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double multiply(Double value1, Double value2) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double multiply(Double value1, Integer value2) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static double multiply(Integer value1, Double value2) {
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.multiply(b2).doubleValue();
    }


    /**
     * 除法运算(四舍五入)
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确范围
     * @return 两个参数的商
     */
    public static double divide(Double value1, Double value2, int scale)  {

        if (scale < 0) {
            throw new RuntimeException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 除法运算(四舍五入)
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确范围
     * @return 两个参数的商
     */
    public static double divide(Double value1, Integer value2, int scale)  {

        if (scale < 0) {
            throw new RuntimeException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(value1.toString());
        BigDecimal b2 = new BigDecimal(value2.toString());
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static double doubleScaleFormat(double v, int scale) {

        return new BigDecimal(v).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }


}
