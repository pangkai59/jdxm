package com.jdxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(basePackages = {"com.jdxm.Mapper"})
@SpringBootApplication
@EnableSwagger2
public class JdxmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdxmApplication.class, args);
	}

}
