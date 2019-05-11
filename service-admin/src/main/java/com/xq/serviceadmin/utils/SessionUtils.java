package com.xq.serviceadmin.utils;

import com.xq.serviceadmin.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: mirrorming
 * @create: 2019-05-01 21:31
 **/

public class SessionUtils {

    public static <T> T getObject(String key, Class<T> clazz) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return (T) request.getSession().getAttribute(key);
        } else
            return null;
    }

    public static String getString(String key) {
        return getObject(key, String.class);
    }

    /**
     * 获取目标方法所在类的所有完整url
     *
     * @param method 目标方法
     * @return
     */
    public static List<String> getUrlList(Method method) {
        List<String> urlList = new ArrayList<>();
        RequestMapping classRequestMapping = method.getDeclaringClass().getAnnotation(RequestMapping.class);
        RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
        if (methodRequestMapping != null) {
            String[] methodValues = methodRequestMapping.value();
            if (classRequestMapping != null) {
                // 类RequestMapping注解value值
                String[] classValues = classRequestMapping.value();
                if (classValues.length > 0) {
                    for (String classValue : classValues) {
                        if (methodValues.length > 0) {
                            for (String methodValue : methodValues) {
                                urlList.add(classValue + methodValue);
                            }
                        } else {
                            urlList.add(classValue);
                        }
                    }
                } else {
                    if (methodValues.length > 0)
                        for (String methodValue : methodValues)
                            urlList.add(methodValue);
                }
            } else {
                if (methodValues.length > 0)
                    for (String methodValue : methodValues)
                        urlList.add(methodValue);
            }
        }
        return urlList;
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("token".equals(cookie.getName())) {
                            token = cookie.getValue();
                            break;
                        }
                    }
                }
            }
        }
        return token;
    }

    /**
     * 获取session中的用户名
     *
     * @return
     */
    public static String getUserNameFromSession() {
        User user = getObject("user", User.class);
        return user == null ? null : user.getUserNickname();
    }

    /**
     * 获取session中的用户
     *
     * @return
     */
    public static User getUserFromSession() {
        return getObject("user", User.class);
    }
}
