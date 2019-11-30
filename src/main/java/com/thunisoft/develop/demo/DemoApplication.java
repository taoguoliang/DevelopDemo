package com.thunisoft.develop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * DemoApplication
 *
 * @description 开发Demo启动类
 * @author taogl
 * @date 2019/11/26 21:01
 * @version v1.0.0
 **/
@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class DemoApplication {

	/**
	 * DemoApplication
	 *
	 * @description 主方法
	 * @param args 启动参数
	 * @author taogl
	 * @date 2019/11/26 21:01
	 * @version v1.0.0
	 **/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
