package org.ustc.dto;

import lombok.Data;

import java.util.List;

@Data
public class CollegeInfoDTO {
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

    List<String> imgUrls;
}
