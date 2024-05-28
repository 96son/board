package com.msoffice.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.msoffice.work")          //war파일 만들기 과정으로 SpringBootServletInitializer 추상 클래스 상속
//scanBasePackages : 컴포넌트 스캔(빈 탐색)을 진행할 베이스 패키지를 설정함
public class WorkApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}
	
	
	 @Override 
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		 
		 return builder.sources(WorkApplication.class); 
	 
	 }
	 

}
