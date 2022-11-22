package com.nexai.writer;

import com.nexai.model.Card;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Set;

public class DataWriter {
    public static final String PATH = "src/main/resources";
    public static final String FILE_NAME = "cards.txt";

    public static void writeCardsInFile(Set<Card> cards) {

        File file = new File(PATH, FILE_NAME);
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, false))) {
            file.createNewFile();
            for (Card card : cards) {
                outputStreamWriter.write(card.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing data to file" + e);

        }
    }
}
