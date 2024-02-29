package org.ustc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ustc.mapper.AssessMapper;
import org.ustc.pojo.Assess;
import org.ustc.pojo.AssessBO;
import org.ustc.restful.ListVO;
import org.ustc.restful.RestResult;
import org.ustc.service.AssessService;
import org.ustc.utils.AuthUtils;
import org.ustc.utils.ChatUtils;

import java.sql.Timestamp;

/**
 * ClassName: AssessServiceImpl
 * Package: org.ustc.service.impl
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Slf4j
@Service
public class AssessServiceImpl implements AssessService {

    @Resource
    private AssessMapper assessMapper;


    @Override
    public RestResult<Object> assess(AssessBO assessBO) {
        // 1.获得当前用户id
        Integer id = AuthUtils.getCurrentUserId();
        if(id == null) return RestResult.fail("用户未登录");
        // 2.组装assess评估信息
        Assess assess = new Assess();
        assess.setGpa(assessBO.getGpa());
        assess.setTime(new Timestamp(System.currentTimeMillis()));
        assess.setLanguage(assessBO.getLanguage());
        assess.setExperience(assessBO.getExperience());
        assess.setStuId(id);
        // 3.调用api获得评估结果
        ChatUtils.chat(assess);
        // 4.插入评估结果并返回
        if(assessMapper.insert(assess) != 1){
            return RestResult.fail("插入失败");
        }
        log.info("用户{}:进行了个人评估", assess.getStuId());
        return RestResult.ok(assess);
    }

    @Override
    public RestResult<Object> getAssessHistory(Integer page, Integer size) {
        // 1.获得当前用户id
        Integer id = AuthUtils.getCurrentUserId();
        if(id == null) return RestResult.fail("用户未登录");
        // 2.分页查询
        LambdaQueryWrapper<Assess> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Assess::getStuId, id);
        Page<Assess> assessPageage = new Page<>(page, size);
        IPage<Assess> assessIPage = assessMapper.selectPage(assessPageage, wrapper);
        // 3.创建 ListVO 对象，并将 IPage 对象的数据转换到 ListVO 对象中
        ListVO<Assess> listVO = new ListVO<>();
        listVO.setRecords(assessIPage.getRecords());
        listVO.setTotal(assessIPage.getTotal());
        listVO.setSize(assessIPage.getSize());
        listVO.setCurrent(assessIPage.getCurrent());
        // 4.返回结果
        return RestResult.ok(listVO);
    }
}
