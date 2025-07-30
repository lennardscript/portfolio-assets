package com.abaqus.portfolio.spring_boot_portfolio.etl.reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ExcelDataReader implements DataReader {

  @Override
  public List<Map<String, String>> read(InputStream inputStream, String sheetName) {

    List<Map<String, String>> data = new ArrayList<>();

    try (Workbook workbook = new XSSFWorkbook(inputStream)) {
      Sheet sheet = workbook.getSheet(sheetName);

      if (sheet == null) {
        throw new IllegalArgumentException("Sheet " + sheetName + " not found in the Excel file.");
      }

      // Get header row
      Row headerRow = sheet.getRow(0);
      if (headerRow == null) {

        throw new IllegalArgumentException("Header row not found in sheet " + sheetName + ".");
      }
      List<String> headers = StreamSupport.stream(headerRow.spliterator(), false)
          .map(Cell::getStringCellValue)
          .collect(Collectors.toList());

      // Iterate over rows starting from the second now (data rows)
      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row currentRow = sheet.getRow(i);
        if (currentRow == null) {
          continue;
        }
        Map<String, String> rowData = new HashMap<>();
        boolean allCellsEmpty = true;

        for (int j = 0; j < headers.size(); j++) {
          Cell cell = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
          String cellValue = getCellValueAsString(cell);
          rowData.put(headers.get(i), cellValue);

          if (!cellValue.trim().isEmpty()) {
            allCellsEmpty = false;
          }
        }

        if (!allCellsEmpty) {
          data.add(rowData);
        }
      }

    } catch (IOException e) {
      throw new RuntimeException("Failed to read Excel file: " + e.getMessage(), e);
    }
    return data;
  }

  private String getCellValueAsString(Cell cell) {
    if (cell == null) {
      return "";
    }
    switch (cell.getCellType()) {
      case STRING:
        return cell.getStringCellValue();
      case NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
          return cell.getDateCellValue().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate().toString();
        } else {
          return String.valueOf(cell.getNumericCellValue());
        }
      case BOOLEAN:
        return String.valueOf(cell.getBooleanCellValue());
      case FORMULA:
        return cell.getCellFormula();
      case BLANK:
        return "";
      default:
        return "";
    }
  }

}
