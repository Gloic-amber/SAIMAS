package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName commenttable
 */
@TableName(value ="commenttable")
@Data
public class Comment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer commentId;

    private Integer schoolId;

    private Integer stuId;

    private String comment;

    private Integer score;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}