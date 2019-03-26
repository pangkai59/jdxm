package com.jdxm.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**   参考
 * Created by twg on 2017/8/22.
 */
@Aspect
@Component
public class SysOperatorLogAspect {
//    @Autowired
//    private SysOperatorLogFacade sysOperatorLogFacade;
//
//    @Around(value = "@annotation(com.haoyun.common.annotation.SysOperatorLog)")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        saveLog(joinPoint);
//        return joinPoint.proceed(joinPoint.getArgs());
//
//    }
//
//    private void saveLog(ProceedingJoinPoint joinPoint) throws IOException {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        Map parameterMap = request.getParameterMap();
//        ActiveUser activeUser = UserInfoUtil.getUserInfo();
//        Class clazz = joinPoint.getTarget().getClass();
//        Method method = ReflectionUtils.findMethod(clazz, joinPoint.getSignature().getName(), null);
//        StringBuilder stringBuilder = new StringBuilder("200");
//        if (parameterMap.isEmpty()) {
//            Object[] objects = joinPoint.getArgs();
//            for (Object object : objects) {
//                if (object instanceof ServletRequest || object instanceof ServletResponse || object instanceof Errors || object instanceof MultipartFile) {
//                    continue;
//                }
//                stringBuilder.append(JSON.toJSONString(object)).append(",");
//            }
//        } else {
//            stringBuilder.append(JSON.toJSONString(parameterMap));
//        }
//        List<SysPermission> sysPermissions = activeUser.getPermissions();
//        //用户拥有的权限
//        Map<String, SysPermission> stringSysPermissionMap = Maps.uniqueIndex(sysPermissions, new Function<SysPermission, String>() {
//            @Override
//            public String apply(SysPermission input) {
//                return input.getPerCode();
//            }
//        });
//        List<SysPermission> sysMenus = Lists.newArrayList();
//        getAllMenus(activeUser.getMenus(), sysMenus);
//        //用户拥有的菜单
//        Map<Long, SysPermission> menuMap = Maps.newHashMap();
//        Map<String, SysPermission> menuUrlMap = Maps.newHashMap();
//        for (SysPermission sysMenu : sysMenus) {
//            menuMap.put(sysMenu.getId(), sysMenu);
//            if (StringUtils.isBlank(sysMenu.getUrl())) {
//                continue;
//            }
//            menuUrlMap.put(sysMenu.getUrl(), sysMenu);
//        }
//        SysOperatorLogEntity sysOperatorLogEntity = new SysOperatorLogEntity();
//        sysOperatorLogEntity.setOrgId(activeUser.getOrgId());
//        sysOperatorLogEntity.setCreater(activeUser.getUserid());
//        sysOperatorLogEntity.setUpdater(activeUser.getUserid());
//        sysOperatorLogEntity.setBusinessObject(stringBuilder.toString().length() > 10000 ? stringBuilder.toString().substring(0,10000) : stringBuilder.toString());
//        sysOperatorLogEntity.setIp(HttpRequestUtil.getIp(servletRequestAttributes.getRequest()));
//        sysOperatorLogEntity.setType(method.getAnnotation(com.haoyun.common.annotation.SysOperatorLog.class).type());
//        sysOperatorLogEntity.setUrl(servletRequestAttributes.getRequest().getRequestURL().toString());
//        setSysPermissionInfo(method, stringSysPermissionMap, menuMap, menuUrlMap, sysOperatorLogEntity, servletRequestAttributes.getRequest());
//        sysOperatorLogFacade.save(sysOperatorLogEntity);
//    }
//
//    private List<SysPermission> getAllMenus(List<SysPermission> sysMenus, List<SysPermission> allMenus) {
//        if(null != sysMenus){
//        	for (SysPermission sysMenu : sysMenus) {
//        		allMenus.add(sysMenu);
//        		getAllMenus(sysMenu.getChildren(), allMenus);
//        	}
//        }
//        return allMenus;
//    }
//
//    //设置权限信息
//    private void setSysPermissionInfo(Method method, Map<String, SysPermission> stringSysPermissionMap, Map<Long, SysPermission> menuMap, Map<String, SysPermission> menuUrlMap, SysOperatorLogEntity sysOperatorLogEntity, HttpServletRequest request) {
//        //判断是否存在org.apache.shiro.authz.annotation.RequiresPermissions注解
//        if (method.isAnnotationPresent(org.apache.shiro.authz.annotation.RequiresPermissions.class)) {
//            String[] strings = method.getAnnotation(org.apache.shiro.authz.annotation.RequiresPermissions.class).value();
//            StringBuilder permissionCode = new StringBuilder();//权限码
//            StringBuilder permissionName = new StringBuilder();//权限名
//            StringBuilder permissionId = new StringBuilder();//权限ID
//            for (String string : strings) {
//                permissionCode.append(string).append(",");
//                if (stringSysPermissionMap.containsKey(string)) {
//                    SysPermission permission = stringSysPermissionMap.get(string);
//                    permissionName.append(permission.getName()).append(",");
//                    permissionId.append(permission.getId()).append(",");
//                    if (menuMap.containsKey(permission.getParentId())) {
//                        sysOperatorLogEntity.setParentSysPermissonId(menuMap.get(permission.getParentId()).getId());
//                        sysOperatorLogEntity.setParentSysPermissonName(menuMap.get(permission.getParentId()).getName());
//                        sysOperatorLogEntity.setParentSysPermissonUrl(menuMap.get(permission.getParentId()).getUrl());
//                    }
//                }
//            }
//            if (permissionId.length() > 1) {
//                permissionId = permissionId.delete(permissionId.length() - 1, permissionId.length());
//            }
//            if (permissionCode.length() > 1) {
//                permissionCode = permissionCode.delete(permissionCode.length() - 1, permissionCode.length());
//            }
//            if (permissionName.length() > 1) {
//                permissionName = permissionName.delete(permissionName.length() - 1, permissionName.length());
//            }
//
//            sysOperatorLogEntity.setSysPermissionPercode(permissionCode.toString());
//            sysOperatorLogEntity.setSysPermissionId(permissionId.toString());
//            sysOperatorLogEntity.setSysPermissionName(permissionName.toString());
//            return;
//        }
//        if (menuUrlMap.containsKey(request.getServletPath())) {
//            SysPermission sysPermission = menuUrlMap.get(request.getServletPath());
//            sysOperatorLogEntity.setSysPermissionId(sysPermission.getId().toString());
//            sysOperatorLogEntity.setSysPermissionName(sysPermission.getName());
//        }
//    }
}
