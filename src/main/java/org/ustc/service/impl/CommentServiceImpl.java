package org.ustc.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.ustc.dto.CommentDTO;
import org.ustc.pojo.Assess;
import org.ustc.pojo.Comment;
import org.ustc.pojo.User;
import org.ustc.restful.ListVO;
import org.ustc.restful.RestResult;
import org.ustc.service.CommentService;
import org.ustc.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.ustc.service.UserService;
import org.ustc.utils.AuthUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author 孙晗斌
* @description 针对表【commenttable】的数据库操作Service实现
* @createDate 2024-03-04 11:24:45
*/
@Slf4j
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{
    @Resource
    private UserService userService;
    @Override
    public RestResult addComment(Comment comment) {
        Integer userId = AuthUtils.getCurrentUserId();
        comment.setStuId(userId);
        boolean save = save(comment);
        if(save){
            return RestResult.ok();
        }
        return RestResult.fail("评论失败",400);
    }

    @Override
    public RestResult delComment(Integer commentId) {
        boolean isSuccess = removeById(commentId);
        if(isSuccess){
            return RestResult.ok();
        }
        return RestResult.fail("没有要删除的评论，删除失败",400);
    }

    @Override
    public RestResult showComments(Integer programId, Integer page, Integer size) {
        //评论分页查询
        Page<Comment> commentPage = query().eq("program_id", programId).page(new Page<>(page, size));
        //转换为dto
        List<CommentDTO> comments = commentPage.getRecords().stream()
                .map(comment -> BeanUtil.copyProperties(comment, CommentDTO.class)).collect(Collectors.toList());
        if(comments==null||comments.isEmpty()){
            return RestResult.ok();
        }
        //批量查询,减少数据库消耗，并加入stuUsername
        List<Integer> idList = comments.stream().map(CommentDTO::getStuId).distinct().collect(Collectors.toList());
        List<User> users = userService.query().in("stu_id", idList).list();
        // 创建用户ID和用户名的映射
        Map<Integer, String> userIdToUsernameMap = users.stream()
                .collect(Collectors.toMap(User::getStuId, User::getStuUsername));
        // 使用映射更新comments中的stuUsername
        comments.forEach(comment -> comment.setStuUsername(userIdToUsernameMap.get(comment.getStuId())));

        // 创建 ListVO 对象，并将 Page 对象的数据转换到 ListVO 对象中
        ListVO<CommentDTO> listVO = new ListVO<>();
        listVO.setRecords(comments);
        listVO.setPages(commentPage.getPages());
        listVO.setSize(commentPage.getSize());
        listVO.setTotal(commentPage.getTotal());
        return RestResult.ok(listVO);
    }

    @Override
    public RestResult updateComment(Comment comment) {
        boolean isSuccess = update(comment, new LambdaUpdateWrapper<Comment>().eq(Comment::getCommentId,comment.getCommentId()));
        if(isSuccess){
            return RestResult.ok();
        }
        return RestResult.fail("修改失败",400);
    }
}




