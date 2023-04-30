package com.soni.practice;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            File inputFile = new File("");
            File outputFile = new File("C://stock/StockOut.txt");

            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            int count;

            while ((count = fis.read()) != -1) {
                fos.write(count);
            }
            fis.close();
            fos.close();
        } catch (
                FileNotFoundException e) {
            System.err.println("FileStreamsReadnWrite: " + e);
        } catch (
                IOException e) {
            System.err.println("FileStreamsReadnWrite: " + e);
        }

    }
}
