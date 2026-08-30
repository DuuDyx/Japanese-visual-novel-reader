package com.jpvnreader;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TokenAnalyzer {

    public void analyze () throws IOException {
        Tokenizer tokeni = new Tokenizer();
        OCR ocr = new OCR();
        BufferedImage imagem = ImageIO.read(new File("C:\\Users\\HOME\\Downloads\\teste.png"));
        List<Token> tokenizer = tokeni.tokenize("私は学校に行きます。");
        for (Token token : tokenizer){
            System.out.println(token.getSurface() + "\t" + token.getAllFeatures());
        }

    }
}
