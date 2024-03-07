package org.ustc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.ustc.dto.CollegeInfoDTO;
import org.ustc.pojo.CollegeInfo;
import org.ustc.service.CollegeImgsService;
import org.ustc.service.CollegeInfoService;
import org.ustc.mapper.CollegeInfoMapper;
import org.springframework.stereotype.Service;
import org.ustc.utils.PageUtils;
import org.ustc.utils.PageQuery;

import java.util.List;
import java.util.Map;

/**
* @author Amadeus
* @description 针对表【college_info_table】的数据库操作Service实现
* @createDate 2024-03-04 20:06:40
*/
@Service
public class CollegeInfoServiceImpl extends ServiceImpl<CollegeInfoMapper, CollegeInfo>
    implements CollegeInfoService{

    @Autowired
    CollegeImgsService collegeImgsService;

    /**
     * 根据院校 Id 查询其详细信息
     * @param collegeId
     * @return
     */
    @Override
    public CollegeInfoDTO getCollegeInfoById(Integer collegeId) {
        // 查询院校详细信息
        CollegeInfoDTO collegeInfoDTO = new CollegeInfoDTO();
        CollegeInfo byId = this.getById(collegeId);
        BeanUtils.copyProperties(byId, collegeInfoDTO);
        // 查询院校详情图
        List<String> imgs = collegeImgsService.getImgsById(collegeId);
        if (imgs != null && imgs.size() != 0) {
            collegeInfoDTO.setImgUrls(imgs);
        }
        return collegeInfoDTO;
    }

    @Override
    public PageUtils getRankingList(Map<String, Object> params) {
        IPage<CollegeInfo> page = this.page(
                new PageQuery<CollegeInfo>().getPage(params),
                null
        );
        return new PageUtils(page);
    }
}




