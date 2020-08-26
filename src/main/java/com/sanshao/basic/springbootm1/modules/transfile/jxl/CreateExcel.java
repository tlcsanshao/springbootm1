package com.sanshao.basic.springbootm1.modules.transfile.jxl;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;

import java.io.File;

public class CreateExcel {
    public static void main(String args[]) {
        try {
            //1:创建excel文件
            File file = new File("test.xls");
            file.createNewFile();

            //2:创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //3:创建sheet,设置第二三四..个sheet，依次类推即可
            WritableSheet sheet = workbook.createSheet("用户管理", 0);
            //4：设置titles
            String[] titles = {"编号", "账号", "密码"};
            //5:单元格
            Label label = null;
            //6:给第一行设置列名
            for (int i = 0; i < titles.length; i++) {
                //x,y,第一行的列名
                label = new Label(i, 0, titles[i]);
                //7：添加单元格
                sheet.addCell(label);
            }


            WritableSheet sheet1 = workbook.createSheet("第二页", 1);
            WritableFont font1 = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
            WritableCellFormat cellFormat1 = new WritableCellFormat(font1);

            sheet1.setColumnView(1, 120);

            label = new Label(1, 0, "zzzzzzzzzzzzzzzzzzzzzz", cellFormat1);
            sheet1.addCell(label);
            label = new Label(2, 0, "zzzzzzzzzzzzzzzzzzzzzz");
            sheet1.addCell(label);


            //写入数据，一定记得写入数据，不然你都开始怀疑世界了，excel里面啥都没有
            workbook.write();
            //最后一步，关闭工作簿
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
