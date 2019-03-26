package com.jdxm.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;


/**
 * 接口调用切面
 * @author zhangwr
 * @date 2018/1/17.
 */
@Aspect
@Component
public class InvokeServiceAop {
/*    private static final Logger logger = Logger.getLogger(InvokeServiceAop.class);
    //定义切点
    @Pointcut("@annotation(com.renrun.yun.manager.common.annotate.SystemServiceLog)")
    public void serviceAspect(){}
    @Autowired
    private ServiceInvokingHistoryService invokingHistoryService;

    @AfterReturning(returning = "result",pointcut = "serviceAspect()")
    public void insertServiceLog(JoinPoint joinPoint, Object result) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String url = request.getRequestURI();
            HttpSession session = request.getSession();
            ServiceInvokingHistory invokingHistory = new ServiceInvokingHistory();
            invokingHistory.setServiceUrl(url);
            invokingHistory.setServiceName(getServiceMethodDescription(joinPoint));
            invokingHistory.setRequestData(getRequestParaMap(request).toJSONString());
            if (result instanceof Map) {
                invokingHistory.setResponseData(JsonUtils.encode(result));
            }
            invokingHistory.setCreatorId(getLoginUserId(session));
            invokingHistory.setCreatorName(getLoginUserName(session));
            invokingHistory.setCreateTime(TimeUtils.date());
            invokingHistory.setModifierId(getLoginUserId(session));
            invokingHistory.setModifierName(getLoginUserName(session));
            invokingHistory.setModifyTime(TimeUtils.date());
            invokingHistoryService.insertSelective(invokingHistory);
        }catch (Exception e) {
            logger.error("异常信息:{}", e);
        }
    }

    private long getLoginUserId(HttpSession session) {
        if (session == null) {
            return 0L;
        }
        return session.getAttribute("uid") == null ? 0L : Long.parseLong(session.getAttribute("uid").toString());
    }

    private String getLoginUserName(HttpSession session){
        if (session == null) {
            return "";
        }
        return session.getAttribute("userName") == null ? "" : session.getAttribute("userName").toString();
    }

    *//**
     * getServiceMethodDescription:获取注解中对方法的描述信息 用于service层注解  . <br/>
     * @author lcma
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     * @since JDK 1.7
     *//*
    private String getServiceMethodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    *//**
     * 因为不同支付接口返回的回调数据不一致，有的是通过参数形式返回，有的是在数据流中返回。
     * 例如支付宝回调数据可以通过req.getParameterMap()获取，但是微信支付的必须去inputstream中获取
     * *//*
    private JSONObject getRequestParaMap (HttpServletRequest request) {
        JSONObject returnJson = new JSONObject();
        if (request.getParameterMap().size() > 0) {
            Map requestParams = request.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                returnJson.put(name, valueStr);
            }
        }else if (request.getContentLength() > 0){
            Map<String,Object> requestParams = HttpRequestUtils.getStreamDataToMap(request);
            for (Iterator iterator = requestParams.keySet().iterator(); iterator.hasNext();) {
                String name = (String) iterator.next();
                Object value = requestParams.get(name);
                returnJson.put(name, value);
            }
        }
        return returnJson;
    }*/

}