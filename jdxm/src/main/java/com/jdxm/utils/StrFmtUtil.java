package com.jdxm.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by swk on 2017/10/7.
 * jd.wang@renrunkeji.com
 */
public class StrFmtUtil {

    private static Logger logger = LoggerFactory.getLogger(StrFmtUtil.class);

    private static Pattern pattern = Pattern.compile("\\{\\{([a-zA-Z0-9]*)\\}\\}");

    /**
     * 渲染消息模版
     *
     * @param template 模版内容
     * @param object   模版参数
     * @return 渲染完的消息
     */
    public static String format(String template, Object object, boolean turnFieldNameUCFirst) {
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String ss = matcher.group(); // 需要替换的字符串

            String fieldName = ss.substring(2, ss.length() - 2);
            if (turnFieldNameUCFirst) {
                fieldName = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            }

            Class clazz = object.getClass();
            String methodName = "get" + fieldName;
            try {
                Method method = clazz.getDeclaredMethod(methodName);
                String valueStr = method.invoke(object).toString();
                // 进行替换
                template = template.replace(ss, valueStr);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        return template;
    }

    public static String format(String template, Object object) {
        return format(template, object, false);
    }

    /**
     * 模板替换
     *
     * @param template
     * @param data
     * @return
     */
    public static String format(String template, Map<String, Object> data) {
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String ss = matcher.group(); // 需要替换的字符串

            String fieldName = ss.substring(2, ss.length() - 2);

            if (data.containsKey(fieldName)) {
                String valueStr = data.get(fieldName).toString();

                // 进行替换
                template = template.replace(ss, valueStr);
            }
        }

        return template;
    }

    public static String formatx(String tpl, Map<String, Object> data) {
//        EnvironmentConfiguration configuration = EnvironmentConfigurationBuilder
//                .configuration()
//                .functions()
//                .add(dateFormat)
//                .and()
//                .build();
//
//        JtwigTemplate template = JtwigTemplate.inlineTemplate(tpl, configuration);
//        JtwigModel model = JtwigModel.newModel(data);
//        return template.render(model);
        return null;
    }

    // {{ date_format("2017-08-20", "yyyy年MM月dd日") }}
//    private static final SimpleJtwigFunction dateFormat = new SimpleJtwigFunction() {
//        @Override
//        public String name() {
//            return "date_format";
//        }
//
//        @Override
//        public Object execute(FunctionRequest functionRequest) {
//            List<Object> args = functionRequest.getArguments();
//            if (args.size() < 2) {
//                return "";
//            }
//
//            String date = (String) args.get(0);
//            String format = (String) args.get(1);
//
//            return TimeUtil.format(date, format);
//        }
//    };

}
