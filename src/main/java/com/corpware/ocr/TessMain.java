package com.corpware.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TessMain {
    public static void main(String[] args) {
        Tesseract instance = new Tesseract();
        instance.setLanguage("ara");
        instance.setDatapath("src/main/resources/tessdata");
        List<ITesseract.RenderedFormat> list = new ArrayList<ITesseract.RenderedFormat>();
        list.add(ITesseract.RenderedFormat.PDF);
        list.add(ITesseract.RenderedFormat.TEXT);
        try {
            instance.setHocr(true);
            File file = new File("src/main/resources/samples/sample.png");
            instance.createDocuments(file.getAbsolutePath(),"src/main/resources/output/result",list);
            instance.setHocr(false);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
