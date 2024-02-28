package org.ustc.service;

import org.ustc.pojo.User;
import org.ustc.pojo.UserRegisterBO;
import org.ustc.restful.RestResult;

/**
 * ClassName: UserService
 * Package: org.ustc.service
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userRegisterBO 用户注册信息
     * @return 返回一个bool值，表示成功或失败
     */
    RestResult<Object> register(UserRegisterBO userRegisterBO);

    User login(String username, String password);
}
