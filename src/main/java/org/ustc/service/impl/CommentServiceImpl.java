package org.ustc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ustc.pojo.Comment;
import org.ustc.service.CommentService;
import org.ustc.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author 孙晗斌
* @description 针对表【commenttable】的数据库操作Service实现
* @createDate 2024-03-04 11:24:45
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




