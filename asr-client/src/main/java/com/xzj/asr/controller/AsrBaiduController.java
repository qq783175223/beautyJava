package com.xzj.asr.controller;

import com.xzj.asr.model.Audio;
import com.xzj.asr.service.AsrBaiduService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * Create by xuzhijun.online on 2019/4/3.
 */

@RestController
@RequestMapping("/baidu-asr")
public class AsrBaiduController {
    @Autowired
    private AsrBaiduService asrBaiduService;

    @PostMapping(path = "")
    public Mono<String> recognize(@Valid @RequestBody Audio audio) {
        System.out.println("**************************请求id = "+audio.getId());
        return this.asrBaiduService.recognize(audio);
    }
}
