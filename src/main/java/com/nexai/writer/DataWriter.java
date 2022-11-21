package com.nexai.writer;

import com.nexai.model.Card;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class DataWriter {
    public boolean writeCardsInFile(List<Card> cards) {
        File file = new File("src/main/resources", "cards.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, false))) {
            file.createNewFile();
            for (Card card : cards) {
                outputStreamWriter.write(card.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing data to file" + e);
            return false;
        }
        return true;

    }
}
