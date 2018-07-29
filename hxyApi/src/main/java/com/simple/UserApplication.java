package com.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.github.tobato.fastdfs.FdfsClientConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenkx
 * @date   2017-12-26
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.simple.mapper"})
@EnableSwagger2
@Import(FdfsClientConfig.class)
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
}
