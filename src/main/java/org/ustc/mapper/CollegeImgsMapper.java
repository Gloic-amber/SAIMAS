package org.ustc.mapper;

import org.apache.ibatis.annotations.Param;
import org.ustc.pojo.CollegeImgs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Amadeus
* @description 针对表【college_imgs_table】的数据库操作Mapper
* @createDate 2024-03-04 20:06:40
* @Entity org.ustc.pojo.CollegeImgs
*/
public interface CollegeImgsMapper extends BaseMapper<CollegeImgs> {

    List<String> getImgsById(@Param("collegeId") Integer collegeId);
}




