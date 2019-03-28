package com.xzj.webflux.dao;

import com.xzj.webflux.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * Create by xuzhijun.online on 2019/3/28.
 */
public interface UserRepository extends ReactiveCrudRepository<User, String> {  // 1
    Mono<User> findByUsername(String username);     // 2
    Mono<Long> deleteByUsername(String username);
}