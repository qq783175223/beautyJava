package com.xzj.asr.model;

import lombok.*;

/**
 * Create by xuzhijun.online on 2019/4/3.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audio {

    private String id;
    private byte[] data;
}
