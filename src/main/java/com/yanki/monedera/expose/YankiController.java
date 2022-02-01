package com.yanki.monedera.expose;

import com.yanki.monedera.business.YankiService;
import com.yanki.monedera.model.Yanki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class YankiController {

  @Autowired
  private YankiService yankiService;

  @PostMapping("/api/yankis")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Yanki> create(@RequestBody Yanki yanki){
    log.info("<--create-->");
    return yankiService.create(yanki);
  }
}
