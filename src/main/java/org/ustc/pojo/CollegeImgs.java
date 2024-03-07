package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName college_imgs_table
 * 院校详情图
 */
@TableName(value ="college_imgs_table")
@Data
public class CollegeImgs implements Serializable {

    /**
     * 图片Id
     */
    @TableId
    private Integer imgId;

    /**
     * 院校Id
     */
    private Integer collegeId;

    /**
     * 院校详情图 url
     */
    private String imgUrl;

    private static final long serialVersionUID = 1L;
}