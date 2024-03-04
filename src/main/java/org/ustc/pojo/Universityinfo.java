package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName universityinfotable
 */
@TableName(value ="universityinfotable")
@Data
public class Universityinfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer schoolId;

    private String schoolName;

    private String academy;

    private String major;

    private String country;

    private String city;

    private Integer ranking;

    private Integer cost;

    private Integer avgScore;

    private static final long serialVersionUID = 1L;
}