package com.xzj.asr.service;

import com.baidu.aip.speech.AipSpeech;
import com.xzj.asr.model.Audio;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Create by xuzhijun.online on 2019/4/3.
 */
@Service
public class AsrBaiduService {

    //设置APPID/AK/SK
    public static final String APP_ID = "15930466";
        public static final String API_KEY = "gXfaCboFO6ORDZrwAAmMupbL";
    public static final String SECRET_KEY = "P1jfQG9EsNx5GrBTfpFe1vqx5nzsODGC";

    static AipSpeech client;
    static{
        // 初始化一个AipSpeech
        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    }

    public Mono<String> recognize(Audio audio){

        byte[] data = audio.getData();
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);

        JSONObject asrRes = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes);
        return Mono.just(asrRes.toString());
    }

}
