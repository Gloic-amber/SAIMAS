package org.ustc.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: CommentDTO
 * Package: org.ustc.pojo
 * Description:
 *
 * @Author showmaker-ustc
 * @Create 2024/3/4 16:16
 * @Version 1.0
 */
@Data
public class CommentDTO {

    private Integer commentId;

    private Integer stuId;

    private String stuUsername;

    private String comment;

    private Integer score;

    private Date updateTime;


}
