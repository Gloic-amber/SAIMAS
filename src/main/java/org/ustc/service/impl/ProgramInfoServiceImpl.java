package org.ustc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;
import org.ustc.pojo.ProgramInfo;
import org.ustc.service.ProgramInfoService;
import org.ustc.mapper.ProgramInfoMapper;
import org.springframework.stereotype.Service;
import org.ustc.utils.PageQuery;
import org.ustc.utils.PageUtils;

import java.util.Map;

/**
* @author Amadeus
* @description 针对表【program_info_table】的数据库操作Service实现
* @createDate 2024-03-04 20:06:40
*/
@Service
public class ProgramInfoServiceImpl extends ServiceImpl<ProgramInfoMapper, ProgramInfo>
    implements ProgramInfoService{

    @Override
    public ProgramInfo getProgramInfoById(Integer programId) {
        return this.getById(programId);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {

        QueryWrapper<ProgramInfo> wrapper = new QueryWrapper<>();
        String key = (String)params.get("key");
        if(StringUtils.hasLength(key)){
            wrapper.and(w->{
                w.like("collegeName", key).or().like("academyName", key).or().like("majorName", key);
            });
        }

        IPage<ProgramInfo> page = this.page(
                new PageQuery<ProgramInfo>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }
}




