package com.sanshao.basic.springbootm1.modules.transfile.jxl;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;


/**
 * @author yrs
 */
public class TWrite {

    public static void write(WritableWorkbook wb) throws WriteException {
        WritableSheet wSheet = wb.createSheet("sheet1", 0);

        //添加Label对象
        Label labelC = new Label(0, 0, "Label cell");
        wSheet.addCell(labelC);


        //添加Number对象
        Number numberC = new Number(0, 1, 3.1415926);
        wSheet.addCell(numberC);

        // 3.添加Boolean对象
        Boolean booleanC = new Boolean(0, 2, true);
        wSheet.addCell(booleanC);

        // 4.添加DateTime对象
        DateTime dateTimeC = new DateTime(0, 3, new java.util.Date());
        wSheet.addCell(dateTimeC);

        // 添加带有字型Formatting的对象
        WritableFont wFont = new WritableFont(
                WritableFont.TIMES, 18, WritableFont.BOLD, true);
        WritableCellFormat wCellFormatC = new WritableCellFormat(wFont);
        Label labelCF = new Label(1, 0, "Label Cell", wCellFormatC);
        wSheet.addCell(labelCF);

        // 添加带有formatting的Number对象
        NumberFormat nFormat = new NumberFormat("#.##");
        WritableCellFormat wCellFormatN = new WritableCellFormat(nFormat);
        Number numberNF = new Number(1, 1, 3.1415926, wCellFormatN);
        wSheet.addCell(numberNF);

        // 添加带有formatting的DateFormat对象
        DateFormat dFormat = new DateFormat(
                "yyyy MM dd hh:mm:ss");
        WritableCellFormat wCellFormatD = new WritableCellFormat(dFormat);
        DateTime dateTimeDF = new DateTime(1, 3, new java.util.Date(), wCellFormatD);
        wSheet.addCell(dateTimeDF);

    }

    public static void main(String[] args) throws IOException, BiffException, WriteException {
        try {

            //文件D://JEtest//read.xls 不存在，若存在数据将会丢失
            File file = new File("write.xls");
            //创建一个新的可写工作簿
            WritableWorkbook wb = Workbook.createWorkbook(file);
            TWrite.write(wb);

            // 写入Exel工作表
            wb.write();
            // 关闭Excel工作薄对象
            wb.close();
        } catch (IOException | WriteException e) {
            System.out.println("Exception:  " + e);
            throw e;
        }
    }
}

