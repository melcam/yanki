package com.yanki.monedera.expose;

import com.yanki.monedera.business.YankiService;
import com.yanki.monedera.model.Yanki;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class YankiController {

  @Autowired
  private YankiService yankiService;

  @GetMapping("/api/yankis/{id}")
  public Mono<Yanki> findById(@PathVariable("id") String id) {
    log.info("<--findById-->");
    return yankiService.findById(id);
  }

  @GetMapping("/api/yankis")
  public Flux<Yanki> findAll() {
    log.info("<--findAll-->");
    return yankiService.findAll();
  }

  @PostMapping("/api/yankis")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Yanki> create(@RequestBody Yanki yanki) {
    log.info("<--create-->");
    return yankiService.create(yanki);
  }

  @PutMapping("/api/yankis")
  public Mono<Yanki> update(@RequestBody Yanki yanki) {
    log.info("<--update-->");
    return yankiService.update(yanki);
  }

  @PatchMapping("/api/yankis")
  public Mono<ResponseEntity<Yanki>> change(@RequestBody Yanki yanki) {
    log.info("<--change-->");
    return yankiService.change(yanki).flatMap(atUpdate -> Mono.just(ResponseEntity.ok(atUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/api/yankis/{id}")
  public Mono<ResponseEntity<Yanki>> delete(@PathVariable("id") String id) {
    log.info("<--delete-->");
    return yankiService.delete(id).flatMap(at -> Mono.just(ResponseEntity.ok(at)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
