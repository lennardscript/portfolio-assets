package com.abaqus.portfolio.spring_boot_portfolio.etl.mapper;

import java.util.List;
import java.util.Map;

public interface DataMapper<T> {
  List<T> map(List<Map<String, String>> rawData);
}
