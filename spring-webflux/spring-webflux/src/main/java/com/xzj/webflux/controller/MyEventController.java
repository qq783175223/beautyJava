package com.xzj.webflux.controller;

import com.xzj.webflux.dao.MyEventRepository;
import com.xzj.webflux.model.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
@RestController
@RequestMapping("/events")
public class MyEventController {
    @Autowired
    private MyEventRepository myEventRepository;

    @PostMapping(path = "", consumes = MediaType.APPLICATION_STREAM_JSON_VALUE) // 1
    public Mono<Void> loadEvents(@RequestBody Flux<MyEvent> events) {
        return this.myEventRepository.insert(events).then();    // 2
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<MyEvent> getEvents() {  // 2
        // TODO
        return this.myEventRepository.findBy();
    }

    @Bean   // 1
    public CommandLineRunner initData(MongoOperations mongo) {  // 2
        return (String... args) -> {    // 3
            mongo.dropCollection(MyEvent.class);    // 4
            mongo.createCollection(MyEvent.class, CollectionOptions.empty().maxDocuments(200).size(100000).capped()); // 5
        };
    }
}