package com.jdxm.utils;



import javax.servlet.http.HttpSession;

/**
 * Created by chenliangwei on 2017/1/16.
 */
public class SessionUtils  {
    protected HttpSession session;


    /**
     * 获取session key对应的值
     * @param key
     * @return
     */
    public Object getSessionKeyVal(String key){
        return session.getAttribute(key);
    }

    /**
     * 获取sessionID
     * @return
     */
    public String getSessionId(){
        return session.getId();
    }

    public void getSession(){
        //接口里要求返回 ServletContext 类型，但是这里这样写是报错的，不知道怎么写
        // session.getServletContext();
    }

    /**
     * 返回session里所有的键
     * @return
     */
    public Object getSessionKeys(){
        return (Object) session.getAttributeNames();
    }
    /**
     * 设置session
     * @param key
     * @param val
     */
    public void setSession(String key,Object val){
        session.setAttribute(key,val);
    }


    /**
     * 删除session的某个键的值
     * @param key
     */
    public void removeSessionName(String key){
        session.removeAttribute(key);
    }
}
