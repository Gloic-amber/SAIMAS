package org.ustc.service;

import org.ustc.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ustc.restful.RestResult;

/**
* @author 孙晗斌
* @description 针对表【commenttable】的数据库操作Service
* @createDate 2024-03-04 11:24:45
*/
public interface CommentService extends IService<Comment> {

    RestResult addComment(Comment comment);

    RestResult delComment(Integer commentId);

    RestResult showComments(Integer schoolId, Integer page, Integer size);



    RestResult updateComment(Comment comment);
}
