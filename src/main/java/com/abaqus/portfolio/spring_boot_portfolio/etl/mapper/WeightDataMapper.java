package com.abaqus.portfolio.spring_boot_portfolio.etl.mapper;

import com.abaqus.portfolio.spring_boot_portfolio.etl.dto.WeightDataRowDTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class WeightDataMapper implements DataMapper<WeightDataRowDTO> {

  @Override
  public List<WeightDataRowDTO> map(List<Map<String, String>> rawData) {
    List<WeightDataRowDTO> weightDataRows = new ArrayList<>();
    for (Map<String, String> rowMap : rawData) {
      String date = rowMap.get("Fecha");
      String assetName = rowMap.get("activos");
      String portfolio1Weight = rowMap.get("portafolio 1");
      String portfolio2Weight = rowMap.get("portafolio 2");
      weightDataRows.add(new WeightDataRowDTO(date, assetName, portfolio1Weight, portfolio2Weight));
    }
    return weightDataRows;
  }
}
