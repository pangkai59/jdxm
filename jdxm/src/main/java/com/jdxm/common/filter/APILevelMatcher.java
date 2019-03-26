package com.jdxm.common.filter;

/**
 * 权限判断过滤器
 * 接口通过路径前缀来分以下四级:
 *
 * /dop/x/y/z  `/dop`后台要权限判断接口
 * /donp/x/y/z `/donp`后台无权限判断接口
 * /wns/x/y/z  `/wns`前台不登录接口
 * /ws/x/y/z   `/ws`前台要登录接口
 * /open/x/y/z `/open`暴露给第三方的接口
 *
 */
public class APILevelMatcher {

    public static final String ADMIN_API_NEED_CHECK_PERM_PREFIX = "/dop";
    public static final String ADMIN_API_NO_NEED_CHECK_PERM_PREFIX = "/donp";
    public static final String FRONT_API_NO_NEED_LOGIN_PREFIX = "/wns";
    public static final String FRONT_API_NEED_LOGIN_PREFIX = "/ws";
    public static final String OPEN_API_PREFIX = "/open";

    public static boolean isAdminAPINeedCheckPerm(String path) {
        return path.startsWith(ADMIN_API_NEED_CHECK_PERM_PREFIX);
    }

    public static boolean isAdminAPINoNeedCheckPerm(String path) {
        return path.startsWith(ADMIN_API_NO_NEED_CHECK_PERM_PREFIX);
    }

    public static boolean isFrontAPINeedLogin(String path) {
        return path.startsWith(FRONT_API_NEED_LOGIN_PREFIX);
    }

    public static boolean isFrontAPINoNeedCheckPerm(String path) {
        return path.startsWith(FRONT_API_NO_NEED_LOGIN_PREFIX)
                || path.startsWith("/swagger")
                || path.startsWith("/api-docs"); // swagger文档特殊处理
    }

    public static boolean isOpenAPI(String path) {
        return path.startsWith(OPEN_API_PREFIX);
    }

}
