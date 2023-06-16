package com.shinn.fileservice;

import com.shinn.model.ProductModel;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

public class ProductWriter extends AbstractWriter implements IWriter<ProductModel>{
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_TITLE = 1;
    public static final int COLUMN_INDEX_PRICE  = 2;
    public static final int COLUMN_INDEX_DISCOUNT = 3;
    public static final int COLUMN_INDEX_QUANTITY = 4;
    public static final int COLUMN_INDEX_CATEGORY = 5;
    public static final int COLUMN_INDEX_TOTAL_MONEY = 6;
    private static CellStyle cellStyleFormatNumber = null;

    public ProductWriter() {

    }
    @Override
    public boolean write(List<ProductModel> list, String path) {
        Workbook workbook = getWorkBook(path);
        Sheet sheet = workbook.createSheet("Products");
        int rowIndex = 0;
        writeHeader(sheet, rowIndex++);
        for(ProductModel productModel: list) {
            Row row = sheet.createRow(rowIndex);
            writeOne(productModel, row);
            rowIndex++;
        }
        String sumCode = "SUM(G2:G" + rowIndex+ ")";
        writeFooter(sheet, rowIndex, COLUMN_INDEX_TOTAL_MONEY, sumCode);

        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        createOutputFile(workbook, path);
        return true;
    }

    @Override
    public boolean writeOne(ProductModel productModel, Row row) {
        if(cellStyleFormatNumber == null) {
            short format = (short)BuiltinFormats.getBuiltinFormat("#, ##0");
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellValue(productModel.getId());
        cell = row.createCell(COLUMN_INDEX_TITLE);
        cell.setCellValue(productModel.getTitle());
        cell =row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellValue(productModel.getPrice());
        cell = row.createCell(COLUMN_INDEX_DISCOUNT);
        cell.setCellValue(productModel.getDiscount());
        cell = row.createCell(COLUMN_INDEX_QUANTITY);
        cell.setCellValue(productModel.getRemainQuality());
        cell = row.createCell(COLUMN_INDEX_CATEGORY);
        cell.setCellValue(productModel.getCategory().getCategoryName());
        cell = row.createCell(COLUMN_INDEX_TOTAL_MONEY);
        if(productModel.getDiscount() > 0) {
            cell.setCellValue(productModel.getDiscount() * productModel.getRemainQuality());
        } else {
            cell.setCellValue(productModel.getPrice() * productModel.getRemainQuality());
        }
        return true;
    }

    @Override
    public void writeHeader(Sheet sheet, int rowIndex) {
        CellStyle cellStyle = createStyleForHeader(sheet);
        Row row = sheet.createRow(rowIndex);

        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Product ID");

        cell = row.createCell(COLUMN_INDEX_TITLE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Title");

        cell = row.createCell(COLUMN_INDEX_PRICE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Price");

        cell = row.createCell(COLUMN_INDEX_DISCOUNT);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Discount");

        cell = row.createCell(COLUMN_INDEX_QUANTITY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Quantity");

        cell = row.createCell(COLUMN_INDEX_CATEGORY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Category");

        cell = row.createCell(COLUMN_INDEX_TOTAL_MONEY);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Total money");
    }

}
