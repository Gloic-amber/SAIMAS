package org.ustc.service;

import org.ustc.pojo.AssessBO;
import org.ustc.pojo.UserBO;
import org.ustc.restful.RestResult;

/**
 * ClassName: AssessService
 * Package: org.ustc.service
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */
public interface AssessService {

    /**
     * 进行个人评估
     * @param assessBO
     * @return 评估结果
     */
    RestResult<Object> assess(AssessBO assessBO);

    /**
     * 获得个人评估历史记录
     * @return
     */
    RestResult<Object> getAssessHistory(Integer page, Integer size);
}
