package com.sh.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing       // JPA Auditing 활성화
@SpringBootApplication   // 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정하는 어노테이션. 특히 어노테이션이 있는 위치부터 설정을 읽기 때문에 항상 프로젝트의 최상단에 있어야 한다.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // run 은 내장was를 실행하는 함수
    }
}
