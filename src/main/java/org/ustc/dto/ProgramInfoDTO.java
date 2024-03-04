package org.ustc.dto;

import lombok.Data;


@Data
public class ProgramInfoDTO {

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

    private Integer avgScore;

}
