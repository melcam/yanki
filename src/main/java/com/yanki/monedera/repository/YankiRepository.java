package com.yanki.monedera.repository;

import com.yanki.monedera.model.Yanki;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface YankiRepository extends ReactiveMongoRepository<Yanki, String> {
  Mono<Yanki> findByPhoneOrImeiOrId(String phone,int imei,String id);

}
