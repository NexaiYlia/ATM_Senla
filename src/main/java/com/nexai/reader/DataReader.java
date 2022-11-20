package com.nexai.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DataReader {
    public static final String filePath = "text.txt";

    public void readCardsFromFile(String filePath) throws IOException {
        FileReader fr= new FileReader(filePath);
        Scanner scan = new Scanner(fr);

        int i = 1;

        while (scan.hasNextLine()) {
            System.out.println(i + " : " + scan.nextLine());
            i++;
        }
        fr.close();
    }
}
