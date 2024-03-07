package org.ustc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName college_info_table
 */
@TableName(value ="college_info_table")
@Data
public class CollegeInfo implements Serializable {
    @TableId
    private Integer collegeId;

    /**
     * 院校名: 中文|英文
     */
    private String collegeName;

    private String region;

    private String city;

    /**
     * 院校 qs 排名
     */
    private Integer qsrank;

    /**
     * 院校 软科 排名
     */
    private Integer rkrank;

    /**
     * 院校 logo url
     */
    private String logoUrl;

    /**
     * 院校主页 url
     */
    private String siteUrl;

    /**
     * 院校简介 url
     */
    private String introduction;


    /**
     * 院校平均分
     */
    private Integer avgScore;

    private static final long serialVersionUID = 1L;
}