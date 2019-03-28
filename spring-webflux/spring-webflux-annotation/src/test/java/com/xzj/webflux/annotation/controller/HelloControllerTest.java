package com.xzj.webflux.annotation.controller;

import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
public class HelloControllerTest {

    /**
     * 1 创建WebClient对象并指定baseUrl；
     * 2 HTTP GET；
     * 3 异步地获取response信息；
     * 4 将response body解析为字符串；
     * 5 打印出来；
     * 6 由于是异步的，我们将测试线程sleep 1秒确保拿到response，也可以像前边的例子一样用CountDownLatch。
     */
    @Test
    public void hello() throws InterruptedException {
        WebClient webClient = WebClient.create("http://localhost:8080");   // 1
        Mono<String> resp = webClient
                .get().uri("/hello") // 2
                .retrieve() // 3
                .bodyToMono(String.class);  // 4
        resp.subscribe(System.out::println);    // 5
        TimeUnit.SECONDS.sleep(1);  // 6
    }
}