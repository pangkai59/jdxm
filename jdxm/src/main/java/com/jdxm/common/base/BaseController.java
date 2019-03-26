package com.jdxm.common.base;


import com.jdxm.utils.NetworkUtils;
import com.jdxm.utils.ReqMultiPartBean;
import com.jdxm.utils.StringUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * BaseDao,Dao需继承此Dao
 *
 * @author qxh since 2015-11-4 下午10:52:36
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Resource
    protected HttpServletRequest req;
    @Resource
    protected HttpSession session;


    //为了确保线程安全，现在用session_id来识别数组
    private String session_id = "";

    /**
     * 获取参数
     *
     * @param key
     * @return
     */
    public String getReq(String key) {
        try {
            return req.getParameter(key);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public String getReq(String key, String defVal) {
        try {
            String val = req.getParameter(key);

            if (val == null || val.equals("")) {
                return defVal;
            }
            return val;
        } catch (Exception e) {
            return defVal;
        }
    }


    /**
     * 获取安全参数，避免SQL注入
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public String getSafeReq(String key, String defVal) {
        try {
            String val = getReq(key, defVal);

            if (validSql(val) == false) { //SQL检查，防SQL注入
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 参数校验，防止SQL注入
     *
     * @param str
     */
    public boolean validSql(String str) {

        String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
                + "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

        Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);

        if (sqlPattern.matcher(str).find()) {
            return false;
        }
        return true;
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @return
     */
    public Integer getReqNull(String key) {
        try {
            String v = req.getParameter(key);
            if(v == null) {
                return null;
            }

            return StringUtils.toInt(v, 0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public int getReq(String key, int defVal) {
        try {
            int val = StringUtils.toInt(req.getParameter(key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public long getReq(String key, long defVal) {
        try {
            long val = StringUtils.toLong(req.getParameter(key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }

    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public float getReq(String key, float defVal) {
        try {
            float val = StringUtils.toFloat(req.getParameter(key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }
    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public boolean getReq(String key, boolean defVal) {
        try {
            boolean val = StringUtils.toBool(req.getParameter(key));

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }
    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public double getReq(String key, double defVal) {
        try {
            double val = StringUtils.toDouble(req.getParameter(key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }

    }

    /**
     * 获取参数
     *
     * @param key
     * @return
     */
    public String getReq(Map<String, String> params, String key) {
        if (params == null || params.size() == 0) {
            return "";
        }
        try {
            return params.get(key);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public String getReq(Map<String, String> params, String key, String defVal) {
        try {
            String val = getReq(params, key);

            if (val == null || val.equals("")) {
                return defVal;
            }
            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public int getReq(Map<String, String> params, String key, int defVal) {
        try {
            int val = StringUtils.toInt(getReq(params, key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public long getReq(Map<String, String> params, String key, long defVal) {
        try {
            long val = StringUtils.toLong(getReq(params, key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public float getReq(Map<String, String> params, String key, float defVal) {
        try {
            float val = StringUtils.toFloat(getReq(params, key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }

    /**
     * 获取参数
     *
     * @param key    字段
     * @param defVal 默认值
     * @return
     */
    public double getReq(Map<String, String> params, String key, double defVal) {
        try {
            double val = StringUtils.toDouble(getReq(params, key));

            if (val == 0) {
                return defVal;
            }

            return val;
        } catch (Exception e) {
            return defVal;
        }
    }


    /**
     * 获得MultiPart结构里的参数列表和文件列表数据
     *
     * @return
     */
    protected ReqMultiPartBean parseMultiPartToData() {
        ReqMultiPartBean rrMultiPartBean = new ReqMultiPartBean();
        //"multipart/form-data"方式比较特殊，需要特殊处理
        if (ServletFileUpload.isMultipartContent(req)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(req);
                for (Object object : items) {
                    FileItem fileItem = (FileItem) object;
                    if (fileItem.isFormField()) {
                        logger.warn("fileItem.getFieldName" + fileItem.getFieldName());
                        rrMultiPartBean.multiParams.put(fileItem.getFieldName(), fileItem.getString("utf-8"));//如果你页面编码是utf-8的
                    } else {
                        rrMultiPartBean.fileItemList.add(fileItem); //文件列表
                        logger.warn("fileItem.getFieldName" + fileItem.getFieldName());
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        } else {
            Map requestParams = req.getParameterMap();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }

                rrMultiPartBean.multiParams.put(name, valueStr);
            }

        }

        return rrMultiPartBean;
    }


    /**
     * 获得参数列表
     *
     * @return
     */
    public Map<String, String> getRequestParams() {
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = req.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }

            params.put(name, valueStr);
        }
        return params;
    }

    /**
     * 获得IP地址
     *
     * @return
     */
    public String getIp() {
        return NetworkUtils.ip(req);
    }
}
