package com.xzj.webflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "event") // 1
public class MyEvent {
    @Id
    private Long id;    // 2
    private String message;
}