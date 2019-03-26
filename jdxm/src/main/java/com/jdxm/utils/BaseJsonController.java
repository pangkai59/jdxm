package com.jdxm.utils;

import com.jdxm.common.base.BaseController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

;

/**
 * BaseDao,Dao需继承此Dao
 *
 * @author qxh since 2015-11-4 下午10:52:36
 */
public class BaseJsonController extends BaseController
{
    /**
     * 返回错误的MAP，此时字段r=0
     * @param msg
     * @return
     */
    public Map<String,Object> rt(String msg)
    {
        HashMap<String,Object> m = new HashMap<String, Object>();
        m.put("r",0);
        m.put("msg",msg);

        return m;
    }


    /**
     * 返回自定义CODE的MAP，此时字段r,msg从参数传入
     * @param r 错误代码
     * @param msg 错误信息
     * @return
     */
    public Map<String,Object> rr(int r,String msg)
    {
        HashMap<String,Object> m = new HashMap<String, Object>();
        m.put("r",r);
        m.put("msg",msg);

        return m;
    }


    /**
     * 返回正确提示的的MAP，此时字段r=1
     * @param m 字段
     * @return
     */
    public Map<String,Object> rr(Map<String,Object> m)
    {
        if (m == null) {
            m = new HashMap<String, Object>();
        }
        m.put("r",1);
        m.put("msg","成功");

        return m;
    }

    /**
     * 返回正确提示的的MAP，此时字段r=1
     * @param m
     * @return
     */
    public Map<String,Object> rr(Map<String,Object> m, String msg)
    {
        if (m == null) {
            m = new HashMap<String, Object>();
        }
        m.put("r",1);
        m.put("msg",msg);

        return m;
    }

    /**
     * 返回正确提示的的MAP，此时字段r=1,rows=[],total=0
     * @param msg
     * @return
     */
    public Map<String,Object> rl(String msg)
    {

        Map<String, Object>    m = new HashMap<String, Object>();

        m.put("rows","");
        m.put("total",0);
        m.put("r",1);
        m.put("msg","");

        return m;
    }

    /**
     * 返回参数错误的信息，参数错误固定值：r=10000,msg 可自定义，默认为参数错误
     * @param msg
     * @return
     */
    public Map<String,Object> rp(String msg)
    {
        Map<String, Object> m = new HashMap<String, Object>();

        m.put("r",10000);//参数错误固定值：r=10000
        m.put("msg",msg == null || msg.equals("") ? "参数错误":msg);

        return m;
    }


    /**
     * 读取远程POST/GET发送过来的JSon字符串
     * @return
     */
    public String readJsonString()
    {
        StringBuffer json = new StringBuffer();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));//读取字节流
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }




}
