package org.ustc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.ustc.config.JwtConfig;
import org.ustc.utils.JwtUtils;

/**
 * ClassName: JwtInterceptor
 * Package: org.ustc.interceptor
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JwtConfig.headerName);
        if (token == null) {
            throw new RuntimeException("未登录");
        }
        if(!JwtUtils.validate(token)){
            throw new RuntimeException("无效的token");
        }
        Integer stuId = JwtUtils.parse(token, Integer.class);
        // 将用户的 ID 保存在 RequestAttributes 中
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        requestAttributes.setAttribute("stuId", stuId, RequestAttributes.SCOPE_REQUEST);
        return true;
    }
}
