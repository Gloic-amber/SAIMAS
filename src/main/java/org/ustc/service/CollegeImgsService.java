package org.ustc.service;

import org.ustc.pojo.CollegeImgs;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Amadeus
* @description 针对表【college_imgs_table】的数据库操作Service
* @createDate 2024-03-04 20:06:40
*/
public interface CollegeImgsService extends IService<CollegeImgs> {

    List<String> getImgsById(Integer collegeId);
}
