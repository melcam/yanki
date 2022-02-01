package com.yanki.monedera.model.dto;

import lombok.Data;

@Data
public class YankiDTO {
  private String id;
  private String phone;
  private int imei;
  private String email;
  private double amount;
}
