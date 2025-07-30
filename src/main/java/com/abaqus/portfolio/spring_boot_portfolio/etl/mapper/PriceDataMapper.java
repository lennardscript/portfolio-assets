package com.abaqus.portfolio.spring_boot_portfolio.etl.mapper;

import com.abaqus.portfolio.spring_boot_portfolio.etl.dto.PriceDataRowDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PriceDataMapper implements DataMapper<PriceDataRowDTO> {

  @Override
  public List<PriceDataRowDTO> map(List<Map<String, String>> rawData) {
    List<PriceDataRowDTO> priceDataRows = new ArrayList<>();

    if (rawData == null || rawData.isEmpty()) {
      return priceDataRows;
    }

    List<String> assetNames = rawData.get(0).keySet().stream()
        .filter(header -> !header.equalsIgnoreCase("Dates"))
        .collect(Collectors.toList());

    for (Map<String, String> rowMap : rawData) {
      String dateStr = rowMap.get("Dates");
      Map<String, String> assetPrices = new HashMap<>();
      for (String assetName : assetNames) {
        assetPrices.put(assetName, rowMap.get(assetName));
      }
      priceDataRows.add(new PriceDataRowDTO(dateStr, assetPrices));
    }
    return priceDataRows;
  }
}
