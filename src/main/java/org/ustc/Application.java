package org.ustc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: main
 * Package: org.ustc
 * Description:
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/2/20
 */

@MapperScan("org.ustc.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
