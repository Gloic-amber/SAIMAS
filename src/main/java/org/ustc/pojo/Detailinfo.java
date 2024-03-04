package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName detailinfotable
 */
@TableName(value ="detailinfotable")
@Data
public class Detailinfo implements Serializable {
    private Integer schoolId;

    private String require1;

    private String procedure1;

    private String list;

    private Date deadline;

    private String telephone;

    private String mail;

    private static final long serialVersionUID = 1L;
}