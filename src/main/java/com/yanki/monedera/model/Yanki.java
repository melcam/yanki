package com.yanki.monedera.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "yanki")
public class Yanki {
  @Id
  private String id;
  private String phone;
  private int imei;
  private String email;
  private double amount;
}
