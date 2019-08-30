package com.jgsu.utils.httpclientutil;

import java.io.File;
import net.sourceforge.tess4j.*;
/**
 * 描述:
 * 验证码识别
 *
 * @author grt
 * @create 2018-02-07 0:03
 */
public class CodeTest {
    public static void main(String[] args) {
        /*File imageFile = new File("E:/CheckCode.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }*/

        File imageFile = new File("D:/CheckCode.jpg");
        Tesseract tessreact = new Tesseract();
        tessreact.setDatapath("e:/a");
        try {
            String result = tessreact.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}