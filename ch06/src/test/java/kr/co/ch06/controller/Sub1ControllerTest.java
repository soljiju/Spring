package kr.co.ch06.controller;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@AutoConfigureMockMvc // MockMvc를 주입하기 위한 어노테이션
@SpringBootTest
class Sub1ControllerTest {


    @Autowired
    private MockMvc mockMvc; // MVC 테스트를 위한 가상 mvc 객체

    @Test
    void hello() throws Exception {

        // 반복문 요청으로 대량 트래픽을 연출
        for(int i=0 ; i<1000 ; i++) {

            mockMvc
                    .perform(get("/sub1/hello"))            // 요청 주소
                    .andExpect(status().isOk())             // 요청 결과 코드
                    .andExpect(view().name("/sub1/hello"))  // 요청 결과 페이지
                    .andDo(print());                        // 요청 테스트 결과 출력

        }
    }

    @RepeatedTest(1000)
    void repeatHello() throws Exception {
        mockMvc
                .perform(get("/sub1/hello"))            // 요청 주소
                .andExpect(status().isOk())             // 요청 결과 코드
                .andExpect(view().name("/sub1/hello"))  // 요청 결과 페이지
                .andDo(print());                        // 요청 테스트 결과 출력
    }

    @Test
    void welcome() throws Exception {

        mockMvc
            .perform(
                    post("/sub1/welcome")
                    .param("uid", "a101")
                    .param("name", "테스트"))              // 요청 주소
            .andExpect(status().isOk())                   // 요청 결과 코드
            .andExpect(view().name("/sub1/welcome"))      // 요청 결과 페이지
            .andDo(print());                              // 요청 테스트 결과 출력
    }

    @Test
    void greeting() throws Exception {

        mockMvc
            .perform(post("/sub1/greeting"))              // 요청 주소
            .andExpect(status().is3xxRedirection())       // 리다이렉트 결과 예상
            .andDo(print());                              // 요청 테스트 결과 출력

    }
}