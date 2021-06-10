package com.sh.book.springboot.web;


import com.sh.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
            excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

//    @Test
//    public void hello가_리턴된다() throws Exception{
//        String hello = "hello";
//        /**
//         * mvc.perform : MockMvc를 통해 http Get 요청을 한다.
//         * .andExpect : 결과를 검증한다.
//         * Status는 응답 코드를 검증하는것(200인지 아닌지를 검증한다)
//         * Content는 응답 본문의 내용을 검증한다.
//         * **/
//        mvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(hello));
//    }
//
//    @Test
//    public void helloDto가_리턴된다() throws Exception{
//        String name = "hello";
//        int amount = 1000;
//
//        /**
//         * param : API 테스트 할 때 사용될 파라미터를 설정한다. String 값만 허용한다.
//         * jasonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명을 명시.
//         * **/
//        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(name)))
//                .andExpect(jsonPath("$.amount", is(amount)));
//
//    }


    @Test
    @WithMockUser(roles = "USER")
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        /**
         * mvc.perform : MockMvc를 통해 http Get 요청을 한다.
         * .andExpect : 결과를 검증한다.
         * Status는 응답 코드를 검증하는것(200인지 아닌지를 검증한다)
         * Content는 응답 본문의 내용을 검증한다.
         * **/
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        /**
         * param : API 테스트 할 때 사용될 파라미터를 설정한다. String 값만 허용한다.
         * jasonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명을 명시.
         * **/
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
