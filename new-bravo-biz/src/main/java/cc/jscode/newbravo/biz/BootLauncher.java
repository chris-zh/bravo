package cc.jscode.newbravo.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 */
@SpringBootApplication(scanBasePackages = "cc.jscode.newbravo")
public class BootLauncher {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BootLauncher.class);
        springApplication.run(args);
    }

}
