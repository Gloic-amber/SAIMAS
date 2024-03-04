package org.ustc.utils;
import baidumodel.constant.ChatRoleConstant;
import baidumodel.entity.chat.*;
import baidumodel.service.BaiduService;
import baidumodel.util.TokenUtil;
import cn.hutool.json.JSONUtil;

import org.ustc.pojo.Assess;

import java.util.Collections;

/**
 * ClassName: ChatUtils
 * Package: org.ustc.utils
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/29
 */
public class ChatUtils {

    private static final String API_KEY = "N0ATQV1zl5LVzi6tLAF1VP1L";

    private static final String API_SECRET = "mmqiNNUgy34RZnXur2CXV3mwRm3VyagS";


    public static void chat(Assess assess){
        // 实例化BaiduService
        BaiduService baiduService = new BaiduService(API_KEY, API_SECRET);
        // 使用
        ErnieBotTurboParam param = ErnieBotTurboParam.builder()
                .messages(Collections.singletonList(BaiduChatMessage.builder()
                        .role(ChatRoleConstant.USER)
                        .content("以下是我的相关信息，你能给出一些好的留学去向吗（地区和学校和专业，给出QS排名）\n" +
                                "校内GPA："+assess.getGpa() + "\n" +
                                "语言水平："+assess.getLanguage() + "\n" +
                                "个人经历："+assess.getExperience()
                                )
                        .build()))
                .temperature(0.95F)
                .penalty_score(1.0F)
                .top_p(0.8F)
                .system("你是一个留学中介，可以为学生给出留学相关的建议")
                .build();
        String token = TokenUtil.getToken(API_KEY, API_SECRET);
        ErnieBotTurboResponse ernieBotTurboResponse = baiduService.ernieBotTurbo(param, token);
        assess.setAdvice(ernieBotTurboResponse.getResult());
    }
}
