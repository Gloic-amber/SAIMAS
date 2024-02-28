package org.ustc.service;

import org.ustc.pojo.User;
import org.ustc.pojo.UserBO;
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
     * @param userBO 用户注册信息
     * @return 返回一个bool值，表示成功或失败
     */
    RestResult<Object> register(UserBO userBO);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 修改用户信息
     * @param userBO
     * @return
     */
    RestResult<Object> alter(UserBO userBO);
}
