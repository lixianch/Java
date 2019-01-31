package io;

import scala.sys.process.ProcessBuilderImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lixianch on 2019/1/31.
 */
public class Copy {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Usable: java Copy srcfile destfile");
            return;
        }

        try (FileInputStream fis = new FileInputStream(args[0]);
                FileOutputStream fos = new FileOutputStream(args[1]);){
            int b;
            while ((b = fis.read()) != -1){
                fos.write(b);
            }
        } catch (IOException e){
                    e.printStackTrace();
        }
    }
}
