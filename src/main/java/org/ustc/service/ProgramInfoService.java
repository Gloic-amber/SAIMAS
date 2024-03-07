package org.ustc.service;

import org.ustc.pojo.ProgramInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ustc.utils.PageUtils;

import java.util.Map;

/**
* @author Amadeus
* @description 针对表【program_info_table】的数据库操作Service
* @createDate 2024-03-04 20:06:40
*/
public interface ProgramInfoService extends IService<ProgramInfo> {

    ProgramInfo getProgramInfoById(Integer programId);

    PageUtils queryPageByCondition(Map<String, Object> params);
}
