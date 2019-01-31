package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lixianch on 2019/1/23.
 */
public class BufferedReaderSample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("pom.xml"))) {
            char[] chars = new char[1];
            int count = br.read(chars);
            while(count > 0) {
                System.out.println(String.valueOf(chars));
                count = br.read(chars);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
