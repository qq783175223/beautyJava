package com.xzj.asr.controller;

import com.baidu.aip.util.Util;
import com.xzj.asr.model.Audio;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;


/**
 * Create by xuzhijun.online on 2019/4/3.
 */
public class AsrBaiduControllerTest {

    @Test
    public void recognize() throws Exception {
        byte[] data =Util.readFileByBytes("C:\\Users\\GoneBoy\\Desktop\\speech-reg\\ffmpeg-20190207-2b8458f-win64-static\\bin\\15521045900.wav");
        Audio audio = new Audio();
        audio.setData(data);
        audio.setId("783175223");

        Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/baidu-asr")
                .contentType(MediaType.APPLICATION_JSON_UTF8) // 2
                .body(Mono.just(audio),Audio.class)
                .retrieve().bodyToMono(String.class);
        resp.subscribe(System.out::println);    // 5

        TimeUnit.SECONDS.sleep(3);  // 6
    }

}