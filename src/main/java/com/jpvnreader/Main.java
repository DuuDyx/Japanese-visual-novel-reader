package com.jpvnreader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ScreenShot screen = new ScreenShot();
        OCR ocr = new OCR();
        TokenAnalyzer token = new TokenAnalyzer();
        // BufferedImage imagem = ImageIO.read(new File("C:\\Users\\HOME\\Downloads\\teste.png"));
        //String texto = ocr.recognize(imagem);

        // System.out.println(texto);
        token.analyze();

    }

}