package org.ustc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ustc.pojo.CollegeImgs;
import org.ustc.service.CollegeImgsService;
import org.ustc.mapper.CollegeImgsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Amadeus
* @description 针对表【college_imgs_table】的数据库操作Service实现
* @createDate 2024-03-04 20:06:40
*/
@Service
public class CollegeImgsServiceImpl extends ServiceImpl<CollegeImgsMapper, CollegeImgs>
    implements CollegeImgsService{

    /**
     * 根据院校 Id 查询院校详情图 Url
     * @param collegeId
     * @return
     */
    @Override
    public List<String> getImgsById(Integer collegeId) {
        return this.baseMapper.getImgsById(collegeId);
    }
}




