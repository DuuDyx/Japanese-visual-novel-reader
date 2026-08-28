package com.jpvnreader;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.write;

//Classe responsável por fazer a screenshot e salvar, sobrescrevendo arquivos anteriores
public class ScreenShot {
    private Robot robot;
    // O objeto da classe robot precisa ser inicializado numa estrutura de try catch
    public ScreenShot(){

            try {
                  robot = new Robot();
                // Pega o tamanho máximo da minha tela
            } catch (AWTException e) {
                throw new RuntimeException("Erro ao inicializar objeto Robot" + e);
            }

    }


    public BufferedImage takeScreenshot() throws IOException {
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(rectangle);
        return image;
    }

    public void saveScreenshot() throws IOException {
        write(takeScreenshot(),"PNG", new File("C:\\game\\textTranslate.png"));
    }


}
