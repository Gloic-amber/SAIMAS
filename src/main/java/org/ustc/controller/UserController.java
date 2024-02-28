package org.ustc.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ustc.config.JwtConfig;
import org.ustc.pojo.User;
import org.ustc.pojo.UserBO;
import org.ustc.restful.RestResult;
import org.ustc.service.UserService;
import org.ustc.utils.JwtUtils;

/**
 * ClassName: UserController
 * Package: org.ustc.controller
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/21
 */


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private HttpServletResponse response;


    /**
     * 注册账号，需要新用户名不重复
     * @param userBO
     * @return
     */
    @PostMapping("/register")
    public RestResult<Object> register(UserBO userBO){
        return userService.register(userBO);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 登录结果
     */
    @PostMapping("/login")
    public RestResult<Object> login(String username, String password){
        User user = userService.login(username, password);
        // 在返回的头部添加token
        if(user != null){
            response.setHeader(JwtConfig.headerName, JwtUtils.createToken("id", user.getStuId()));
            response.setHeader("Access-Control-Expose-Headers", JwtConfig.headerName);// 让客户端可以访问jwt
            return RestResult.ok();
        }
        return RestResult.fail();
    }

    /**
     * 修改用户信息，需要jwt
     * @param userBO
     * @return 修改结果
     */
    @PutMapping("/alter")
    public RestResult<Object> alter(UserBO userBO){
        return userService.alter(userBO);
    }

}
