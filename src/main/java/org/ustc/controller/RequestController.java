package org.ustc.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ustc.dto.RequestDto;
import org.ustc.restful.RestResult;

/**
 * ClassName: RequestController
 * Package: org.ustc.controller
 * Description:
 *
 * @Author showmaker-ustc
 * @Create 2024/3/4 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/apply")
public class RequestController {
    @PostMapping("/send")
    public RestResult sentApply(RequestDto request){

        return RestResult.ok(request);
    }
}
