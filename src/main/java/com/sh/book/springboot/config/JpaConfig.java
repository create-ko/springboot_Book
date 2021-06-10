package com.sh.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
    /**
     * EnableJpaAuditing과 SpringBootApplication이 함께 있으면 @WebMvcTest에서도 스캔하게 된다.
     * 그래서 두개를 분리하여 TEST를 수월하게 한다.
     * **/
}
