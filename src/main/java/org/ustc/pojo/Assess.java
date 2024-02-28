package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: SelfAssess
 * Package: org.ustc.pojo
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Data
@TableName("selfAssessTable")
public class Assess {

    @TableId
    Integer assessId;

    Integer stuId;

    Integer gpa;

    String language;

    String experience;

    Timestamp time;

    String advice;
}
