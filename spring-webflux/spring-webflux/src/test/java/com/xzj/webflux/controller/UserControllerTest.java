package com.xzj.webflux.controller;

import com.xzj.webflux.model.User;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.Assert.*;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
public class UserControllerTest {

    /**
     * 1 这次我们使用WebClientBuilder来构建WebClient对象；
     * 2 配置请求Header：Content-Type: application/stream+json；
     * 3 获取response信息，返回值为ClientResponse，retrive()可以看做是exchange()方法的“快捷版”；
     * 4 使用flatMap来将ClientResponse映射为Flux；
     * 5 只读地peek每个元素，然后打印出来，它并不是subscribe，所以不会触发流；
     * 6 上个例子中sleep的方式有点low，blockLast方法，顾名思义，在收到最后一个元素前会阻塞，响应式业务场景中慎用。
     */
    @Test
    public void findAll() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build(); // 1
        webClient
                .get().uri("/user")
                .accept(MediaType.APPLICATION_STREAM_JSON) // 2
                .exchange() // 3
                .flatMapMany(response -> response.bodyToFlux(User.class))   // 4
                .doOnNext(System.out::println)  // 5
                .blockLast();   // 6
    }
}