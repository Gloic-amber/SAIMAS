package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: AssessBO
 * Package: org.ustc.pojo
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/29
 */

@Data
public class AssessBO {

    Integer gpa;

    String language;

    String experience;

}
