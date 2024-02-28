package org.ustc.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ustc.mapper.UserMapper;
import org.ustc.pojo.User;
import org.ustc.pojo.UserRegisterBO;
import org.ustc.restful.RestResult;
import org.ustc.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Package: org.ustc.service.impl
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public RestResult<Object> register(UserRegisterBO userRegisterBO) {
        // 1.检查用户名是否已经存在
        if(userMapper.selectByUserName(userRegisterBO.getUsername()) != null){
            return RestResult.fail("用户名已存在");
        }
        // 2.插入数据
        User user = new User();
        user.setStuName(userRegisterBO.getName());
        user.setStuUsername(userRegisterBO.getUsername());
        user.setStuPassword(passwordEncoder.encode(userRegisterBO.getPassword()));
        if(userMapper.insertUser(user) != 1){
            return RestResult.fail();
        }
        log.info("新用户注册：id->{}", user.getStuId());
        // 3.返回结果
        return RestResult.ok();
    }

    @Override
    public User login(String username, String password) {
        User user;
        // 1.查找用户
        if((user = userMapper.selectByUserName(username)) == null){
            return null;
        }
        // 2.校验密码
        if(!passwordEncoder.matches(password, user.getStuPassword())){
            return null;
        }
        // 3.返回
        log.info("用户登录：id->{}", user.getStuId());
        return user;
    }
}
