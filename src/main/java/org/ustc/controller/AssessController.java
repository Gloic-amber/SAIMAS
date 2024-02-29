package org.ustc.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.ustc.pojo.AssessBO;
import org.ustc.restful.RestResult;
import org.ustc.service.AssessService;

/**
 * ClassName: AssessController
 * Package: org.ustc.controller
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Slf4j
@RestController
@RequestMapping("/evaluate")
public class AssessController {

    @Resource
    private AssessService assessService;

    @PutMapping("/assess")
    public RestResult<Object> assess(AssessBO assessBO){
        return assessService.assess(assessBO);
    }

    @GetMapping("/history")
    public RestResult<Object> getAssessHistory(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size){
        return assessService.getAssessHistory(page, size);
    }
}
