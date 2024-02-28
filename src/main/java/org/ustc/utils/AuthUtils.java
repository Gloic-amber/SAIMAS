package org.ustc.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName: AuthUtils
 * Package: org.ustc.utils
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */
public class AuthUtils {
    public static final String USER_ID_HEADER = "stuId";

    /**
     * 获取当前用户的id
     *
     * @return 当前用户id，当用户未登录时为null
     */
    public static Integer getCurrentUserId() {
        // 获取当前线程的请求
        RequestAttributes attribute = RequestContextHolder.currentRequestAttributes();
        // 获取请求中的用户信息
        Integer stuId = (Integer) attribute.getAttribute(USER_ID_HEADER, RequestAttributes.SCOPE_REQUEST);
        if(stuId == null) return null;
        return stuId;
    }
}
