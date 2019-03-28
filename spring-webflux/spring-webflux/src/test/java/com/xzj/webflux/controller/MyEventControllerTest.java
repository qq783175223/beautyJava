package com.xzj.webflux.controller;

import com.xzj.webflux.model.MyEvent;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.junit.Assert.*;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
public class MyEventControllerTest {

    /**
     * 1 声明速度为每秒一个MyEvent元素的数据流，不加take的话表示无限个元素的数据流；
     * 2 声明请求体的数据格式为application/stream+json；
     * 3 body方法设置请求体的数据。
     */
    @Test
    public void loadEvents() {
        Flux<MyEvent> eventFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> new MyEvent(System.currentTimeMillis(), "message-" + l)).take(5); // 1
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .post().uri("/events")
                .contentType(MediaType.APPLICATION_STREAM_JSON) // 2
                .body(eventFlux, MyEvent.class) // 3
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @Test
    public void getEvents() {
    }
}