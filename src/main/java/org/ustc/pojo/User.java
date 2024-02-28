package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName: Student
 * Package: org.ustc.pojo
 * Description:
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Data
@TableName("stuInfoTable")
public class User {
    /**
     * 学生id
     */
    @TableId
    Integer stuId;

    String stuName;

    String stuPassword;

    String stuUsername;

}
