package org.ustc.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.ustc.config.JwtConfig;

import java.util.Date;

/**
 * ClassName: JwtUtils
 * Package: org.ustc.utils
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/28
 */

@Slf4j
public class JwtUtils {

    /**
     * 生成token
     * @param name
     * @param o
     * @return
     */
    public static String createToken(String name, Object o) {
        return createToken(name, o, JwtConfig.expiration);
    }

    /**
     * 生成token
     *
     * @param name      名称
     * @param data      payload 内容
     * @param validTime 有效时间，单位->秒
     * @return token
     */
    public static String createToken(String name, Object data, long validTime) {
        JWT token = JWT.create();
        token.setPayload(name, data);
        // 设置密钥
        token.setSigner(JWTSignerUtil.hs512(JwtConfig.key.getBytes()));
        // 设置失效时间和密钥、设置签发时间和签发人
        Date date = new Date(System.currentTimeMillis() + (validTime * 1000L));
        token.setIssuer(JwtConfig.issuer).setExpiresAt(date);
        return token.sign();
    }

    /**
     * 验证签名是否正确，以及是否过期
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean validate(String token) {
        try {
            // 验证签名是否正确
            JWTValidator.of(token).validateAlgorithm(JWTSignerUtil.hs512(JwtConfig.key.getBytes()));
            // 验证时间是否正常
            JWTValidator.of(token).validateDate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 解析data数据，若数据类型不一致，则会解析出属性为null，但对象不会为null
     *
     * @param jwt 要被解析的jwt
     * @param clz 解析成的类型
     * @param <T> 类型
     * @return clz类型对象
     */
    public static <T> T parse(String jwt, Class<T> clz) {
        JSONObject data = (JSONObject) JWT.of(jwt).getPayload("data");
        return data.toBean(clz);
    }
}
