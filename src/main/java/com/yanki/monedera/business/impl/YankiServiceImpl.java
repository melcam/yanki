package com.yanki.monedera.business.impl;

import com.yanki.monedera.business.YankiService;
import com.yanki.monedera.model.Yanki;
import com.yanki.monedera.repository.YankiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class YankiServiceImpl implements YankiService {
  @Autowired
  private YankiRepository yankiRepository;

  @Override
  public Mono<Yanki> findById(String id) {
    return yankiRepository.findById(id);
  }

  @Override
  public Flux<Yanki> findAll() {
    return yankiRepository.findAll();
  }

  @Override
  public Mono<Yanki> create(Yanki yanki) {
    log.info("Create Yanki-->");
    /*return yankiRepository.findByPhoneOrImeiOrId(yanki.getPhone(), yanki.getImei(), yanki.getId())
        .flatMap(y -> {
          yanki.setId(y.getId());
          yanki.setPhone(y.getPhone());
          yanki.setImei(y.getImei());
          yanki.setEmail(y.getEmail());
          return yankiRepository.save(yanki);
        }).switchIfEmpty(Mono.empty());*/
        return yankiRepository.save(yanki);
  }

  @Override
  public Mono<Yanki> update(Yanki yanki) {
    return yankiRepository.findById(yanki.getId())
        .map(y -> yanki)
        .flatMap(this.yankiRepository::save);
  }

  @Override
  public Mono<Yanki> change(Yanki yanki) {
    return yankiRepository.findById(yanki.getId())
        .flatMap(y -> {
          return create(yanki);
        })
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Yanki> delete(String id) {
    return yankiRepository.findById(id)
        .flatMap(y -> yankiRepository.deleteById(y.getId()).thenReturn(y));
  }

}
