package springboot2.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SuppressWarnings("unchecked")
@SpringBootApplication(scanBasePackages = "springboot2.springboot")
//@ComponentScan(basePackages = "springboot2.springboot")
@EnableTransactionManagement
@MapperScan(basePackages = "springboot2.springboot.dao")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
