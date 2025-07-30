package com.abaqus.portfolio.spring_boot_portfolio.etl.dto;

import lombok.Data;

@Data
public class WeightDataRowDTO {
  private String date;
  private String assetName;
  private String portfolioWeight;
  private String portfolio2Weight;

  public WeightDataRowDTO(String date, String assetName, String portfolioWeight, String portfolio2Weight) {
    this.date = date;
    this.assetName = assetName;
    this.portfolioWeight = portfolioWeight;
    this.portfolio2Weight = portfolioWeight;
  }

}
