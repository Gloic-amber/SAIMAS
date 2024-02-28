package org.ustc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.ustc.pojo.User;

/**
 * ClassName: UserMapper
 * Package: org.ustc.mapper
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/21
 */

@Mapper
public interface UserMapper extends BaseMapper<User>{

    /**
     * 插入新用户信息
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User selectByUserName(String username);

}
