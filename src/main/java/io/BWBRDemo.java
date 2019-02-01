package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class BWBRDemo {
    static String[] lines = {
            "It was the best of times, it was the worst of times,",
            "it was the age of wisdom, it was the age of foolishness,",
            "it was the epoch of belief, it was the epoch of incredulity,",
            "it was the season of Light, it was the season of Darkness,",
            "it was the spring of hope, it was the winter of despair."
    };
    public static final String FILENAME = "tmp";
    public static void main(String[] args) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))){
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME))){
            String s;
            while((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
