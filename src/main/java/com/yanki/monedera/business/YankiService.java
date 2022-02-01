package com.yanki.monedera.business;

import com.yanki.monedera.model.Yanki;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface YankiService {
  Mono<Yanki> findById(String id);

  Flux<Yanki> findAll();

  Mono<Yanki> create(Yanki yanki);

  Mono<Yanki> update(Yanki yanki);

  Mono<Yanki> change(Yanki yanki);

  Mono<Yanki> delete(String id);
}
