package com.jpvnreader;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class OCR {
    Tesseract tesseract = new Tesseract();


    //Método que vai ler a bufferedImage e retornar em texto, basicamente só pega o texto
    public String recognize (BufferedImage bufferedImage){
        try {
            tesseract.setLanguage("jpn");
            tesseract.setDatapath("C:\\Users\\HOME\\Documents\\untitled\\tessdata");
            return tesseract.doOCR(bufferedImage);
        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }

    }

}
