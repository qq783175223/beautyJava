package com.xzj.webflux.function.config;

import com.xzj.webflux.function.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), timeHandler::getTime)
                .andRoute(GET("/date"), timeHandler::getDate)
                .andRoute(GET("/times"), timeHandler::sendTimePerSec);  // 增加这一行
    }
}