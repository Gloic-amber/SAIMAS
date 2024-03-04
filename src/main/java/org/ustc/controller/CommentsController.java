package org.ustc.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.ustc.pojo.Comment;
import org.ustc.restful.RestResult;
import org.ustc.service.CommentService;


/**
 * ClassName: CommentController
 * Package: org.ustc.controller
 * Description:
 *
 * @Author showmaker-ustc
 * @Create 2024/3/4 15:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/comments" )
public class CommentsController {
    @Resource
    private CommentService commentService;

    /**
     * 添加评论
     */
    @PostMapping("/add")
    public RestResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
    /**
     * 删除评论
     */
    @DeleteMapping("/del")
    public RestResult delComment(@RequestParam("id") Integer commentId){
        return commentService.delComment(commentId);
    }
    /**
     * 获取一所学校的全体评论，应该在前端学校详情页展示
     */
    @GetMapping("/get")
    public RestResult showComments(@RequestParam("schoolId") Integer schoolId,
                                   @RequestParam(value = "page",defaultValue="1") Integer page,
                                   @RequestParam(value = "size", defaultValue = "10") Integer size){
        return commentService.showComments(schoolId,page,size);
    }
    /**
     * 修改评论
     */
    @PostMapping("/update")
    public RestResult updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }
}
