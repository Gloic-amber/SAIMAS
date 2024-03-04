package org.ustc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ustc.dto.CollegeInfoDTO;
import org.ustc.restful.RestResult;
import org.ustc.service.CollegeInfoService;
import org.ustc.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/college")
public class CollegeInfoController {

    @Autowired
    CollegeInfoService collegeInfoService;

    /**
     * 根据院校 Id 查询其详细信息
     * @param collegeId
     * @return
     */
    @GetMapping("/info")
    public RestResult getCollegeInfoById(@RequestParam("collegeId") Integer collegeId) {
        CollegeInfoDTO collegeInfoDTO = collegeInfoService.getCollegeInfoById(collegeId);
        return RestResult.ok(collegeInfoDTO);
    }

    /**
     * 获取院校排名
     * @param params
     * @return
     */
    @RequestMapping("/rankingList")
    public RestResult getRankingList(@RequestParam Map<String, Object> params){
        PageUtils page = collegeInfoService.getRankingList(params);
        return RestResult.ok(page);
    }


}
