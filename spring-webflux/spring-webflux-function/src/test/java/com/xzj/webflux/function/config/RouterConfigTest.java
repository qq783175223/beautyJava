package com.xzj.webflux.function.config;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.Assert.*;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
public class RouterConfigTest {

    /**
     * 1 配置请求Header：Content-Type: text/event-stream，即SSE；
     * 2 这次用log()代替doOnNext(System.out::println)来查看每个元素；
     * 3 由于/times是一个无限流，这里取前10个，会导致流被取消；
     */
    @Test
    public void timerRouter() {
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .get().uri("/times")
                .accept(MediaType.TEXT_EVENT_STREAM)    // 1
                .retrieve()
                .bodyToFlux(String.class)
                .log()  // 2
                .take(10)   // 3
                .blockLast();
    }
}