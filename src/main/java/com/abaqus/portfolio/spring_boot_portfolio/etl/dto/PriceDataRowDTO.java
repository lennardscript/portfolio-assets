package com.abaqus.portfolio.spring_boot_portfolio.etl.dto;

import java.util.Map;

import lombok.Data;

@Data
public class PriceDataRowDTO {
  private String date;
  private Map<String, String> assetsPrices;

  public PriceDataRowDTO(String date, Map<String, String> assetsPrices) {
    this.date = date;
    this.assetsPrices = assetsPrices;
  }
}
