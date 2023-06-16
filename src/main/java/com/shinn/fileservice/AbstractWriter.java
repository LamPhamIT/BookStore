package com.shinn.fileservice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AbstractWriter {
    protected Workbook getWorkBook(String filePath) {
        Workbook workbook = null;
        if(filePath.endsWith("xlsx")) {

        } else if(filePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("File is not excel file");
        }
        return workbook;
    }
    protected CellStyle createStyleForHeader(Sheet sheet) {
        Font font =  sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        font.setColor(IndexedColors.WHITE.getIndex());
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;

    }

    protected void createOutputFile(Workbook workbook, String filePath) {
        try {
            OutputStream os = new FileOutputStream(filePath);
            workbook.write(os);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
    protected static void writeFooter(Sheet sheet, int rowIndex, int totalColumn, String sumCode) {
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(totalColumn, CellType.FORMULA);
        cell.setCellFormula(sumCode);
    }

}
