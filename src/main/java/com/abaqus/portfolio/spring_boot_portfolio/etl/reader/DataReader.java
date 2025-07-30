package com.abaqus.portfolio.spring_boot_portfolio.etl.reader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Interface for reading data from a source, such as an Excel or CSV file.
 * Returns a list of maps, where each map represents a row.
 * 
 * @author Leandro Burgos
 */
public interface DataReader {
  List<Map<String, String>> read(InputStream inputStream, String sheetName);
}
