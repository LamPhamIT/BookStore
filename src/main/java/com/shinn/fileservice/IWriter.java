package com.shinn.fileservice;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface IWriter<T> {
    public abstract boolean write(List<T> list, String path);
    public abstract boolean writeOne(T t, Row row);
    public abstract void writeHeader(Sheet sheet, int rowIndex);




}
