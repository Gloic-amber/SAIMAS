package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName program_info_table
 */
@TableName(value ="program_info_table")
@Data
public class ProgramInfo implements Serializable {
    @TableId
    private Integer programId;

    private Integer collegeId;

    private String collegeName;

    /**
     * 学院名: 中文|英文
     */
    private String academyName;

    /**
     * 专业名: 中文|英文
     */
    private String majorName;

    private String region;

    private String introduction;

    private String requirement;

    private String proc;

    private String applicationDocuments;

    private Date deadline;

    private String telephone;

    private String mail;

    private Integer cost;

    private Integer avgScore;

    private static final long serialVersionUID = 1L;
}