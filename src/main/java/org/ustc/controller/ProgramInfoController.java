package org.ustc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ustc.pojo.Collect;
import org.ustc.pojo.ProgramInfo;
import org.ustc.restful.RestResult;
import org.ustc.service.CollectService;
import org.ustc.service.ProgramInfoService;
import org.ustc.utils.PageUtils;

import java.util.Map;

@RestController
@RequestMapping("/program")
public class ProgramInfoController {

    @Autowired
    ProgramInfoService programInfoService;

    @Autowired
    CollectService collectService;
    /**
     * 根据留学项目 Id 查询其详细信息
     * @param programId
     * @return
     */
    @GetMapping("/info")
    public RestResult getProgramInfoById(@RequestParam("programId") Integer programId) {
        ProgramInfo programInfo = programInfoService.getProgramInfoById(programId);
        return RestResult.ok(programInfo);
    }

    /**
     * 分页查询留学项目（概要）信息
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public RestResult queryPageByCondition(@RequestParam Map<String, Object> params){
        PageUtils page = programInfoService.queryPageByCondition(params);
        return RestResult.ok(page);
    }

    @PostMapping("/collect")
    public RestResult collect(@RequestBody Collect collect){
        collectService.save(collect);
        return RestResult.ok();
    }

}
