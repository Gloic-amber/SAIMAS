package org.ustc.service;

import org.ustc.dto.CollegeInfoDTO;
import org.ustc.pojo.CollegeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ustc.utils.PageUtils;

import java.util.Map;

/**
* @author Amadeus
* @description 针对表【college_info_table】的数据库操作Service
* @createDate 2024-03-04 20:06:40
*/
public interface CollegeInfoService extends IService<CollegeInfo> {

    CollegeInfoDTO getCollegeInfoById(Integer collegeId);

    PageUtils getRankingList(Map<String, Object> params);
}
