package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lixianch on 2019/2/1.
 */
public class FWFRDemo {
    public static final String MSG = "Test message";
    public static final String FILENAME = "tmp";
    public static void main(String[] args) throws IOException {
        try(FileWriter writer = new FileWriter(FILENAME)){
            writer.write(MSG);
        }

        char[] chars = new char[MSG.length()];
        try(FileReader reader = new FileReader(FILENAME)){
            reader.read(chars, 0, chars.length);
            System.out.println(String.valueOf(chars));
        }
    }
}
