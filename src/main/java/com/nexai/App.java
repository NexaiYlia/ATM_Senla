package com.nexai;

import com.nexai.reader.DataReader;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        DataReader dataReader = new DataReader();
        dataReader.readCardsFromFile("src\main\java");
    }
}
