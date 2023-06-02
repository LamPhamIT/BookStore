package com.shinn.controller.web;

import com.shinn.model.UserModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.swing.border.Border;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Writer {
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_EMAIL = 1;
    public static final int COLUMN_INDEX_PASSWORD  = 2;
    public static final int COLUMN_INDEX_FIRSTNAME = 3;
    public static final int COLUMN_INDEX_LASTNAME = 4;
    public static final int COLUMN_INDEX_PHONENUMBER = 5;
    public static final int COLUMN_INDEX_ROLE = 6;
    private static CellStyle cellStyleFormatNumber = null;

    public static Writer writer;
    private Writer() {

    }
    public static Writer getInstance() {
        if(writer == null) {
            writer = new Writer();
        }
        return writer;
    }

    public boolean writeExcel(List<UserModel> users, String filePath) {
        Workbook workbook = getWorkBook(filePath);
        Sheet sheet = workbook.createSheet("users");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex++);
        for(UserModel user : users) {
            Row row = sheet.createRow(rowIndex);
            writeUser(user, row);
            rowIndex++;
        }
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        createOutputFile(workbook, filePath);

        return true;
    }

    private Workbook getWorkBook(String filePath) {
        Workbook workbook = null;
        if(filePath.endsWith("xlsx")) {

        } else if(filePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("File is not excel file");
        }
        return workbook;
    }
    private void writeHeader(Sheet sheet, int rowIndex){
        CellStyle cellStyle = createStyleForHeader(sheet);
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("User ID");

        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");

        cell = row.createCell(COLUMN_INDEX_PASSWORD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Password");

        cell = row.createCell(COLUMN_INDEX_FIRSTNAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("First name");

        cell = row.createCell(COLUMN_INDEX_LASTNAME);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Last name");

        cell = row.createCell(COLUMN_INDEX_PHONENUMBER);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Phone number");

        cell = row.createCell(COLUMN_INDEX_ROLE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Role");

    }

    private CellStyle createStyleForHeader(Sheet sheet) {
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

    private void writeUser(UserModel user, Row row) {
        if(cellStyleFormatNumber == null) {
            short format = (short)BuiltinFormats.getBuiltinFormat("#, ##0");
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(user.getId());
        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue(user.getEmail());
        cell =row.createCell(COLUMN_INDEX_PASSWORD);
        cell.setCellValue(user.getPassword());
        cell = row.createCell(COLUMN_INDEX_FIRSTNAME);
        cell.setCellValue(user.getFirstName());
        cell = row.createCell(COLUMN_INDEX_LASTNAME);
        cell.setCellValue(user.getLastName());
        cell = row.createCell(COLUMN_INDEX_PHONENUMBER);
        cell.setCellValue(user.getPassword());
        cell = row.createCell(COLUMN_INDEX_ROLE);
        cell.setCellValue(user.getRole().getId());
    }
    private void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
    private void createOutputFile(Workbook workbook, String filePath) {
        try {
            OutputStream os = new FileOutputStream(filePath);
            workbook.write(os);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
