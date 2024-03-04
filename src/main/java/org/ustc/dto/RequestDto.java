package org.ustc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: RequestDTO
 * Package: org.ustc.dto
 * Description:
 *      暂存存留学申请
 * @Author showmaker-ustc
 * @Create 2024/3/4 17:01
 * @Version 1.0
 */
@Data
public class RequestDto implements Serializable {

    private String address;
    private String age;
    private String background;
    private String email;
    private Double gpa;
    private String language;
    private String name;
    private String others;
    private String personalStatement;
    private String phone;
    private String preferredMajor;
    private String preferredSchool;
}