package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName applytable
 */
@TableName(value ="applytable")
@Data
public class Apply implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer applyId;

    private Integer stuId;

    private String school;

    private String academy;

    private String major;

    private String material;

    private Integer status;

    private static final long serialVersionUID = 1L;
}