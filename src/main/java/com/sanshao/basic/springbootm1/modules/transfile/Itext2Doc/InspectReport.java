package com.sanshao.basic.springbootm1.modules.transfile.Itext2Doc;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class InspectReport {

    public static Document createDoc() throws FileNotFoundException, DocumentException {
        Document document = new Document();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = sdf.format(System.currentTimeMillis());

        String fileName = "Inspect Report" + "_" + date + ".pdf";
        System.out.println("filename=" + fileName);
        RtfWriter2.getInstance(document, new FileOutputStream("word2.doc"));

        document.open();

        return document;
    }

    public static boolean addTitle(Document document) throws DocumentException, IOException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font keyFont = new Font(bfChinese, 40, Font.BOLD);
        Font textFont = new Font(bfChinese, 20, Font.NORMAL);

        String title = "Inspect Report";
        Paragraph paragraph = new Paragraph(title, keyFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        document.add(paragraph);
        document.add(Chunk.NEWLINE);

        String generateTime = "20201111";
        paragraph = new Paragraph("Inspect Report" + generateTime, textFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        document.add(paragraph);
        return true;
    }

    public static void main(String[] args) throws Exception {
        Document document = createDoc();
        addTitle(document);
        document.close();
    }

}
