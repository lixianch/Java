package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("publish.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        try(FileOutputStream out = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(out)){
            writer.write('我');
        } catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream in = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(in)){
            char[] chars = new char[10];
            reader.read(chars, 0, 10);
            System.out.println(String.valueOf(chars));
        } catch (IOException e){
                e.printStackTrace();
        }

    }
}
