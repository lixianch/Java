package io;

import java.io.*;

/**
 * Created by lixianch on 2019/2/1.
 */
public class RedirectIO {
    public static void main(String[] args) throws IOException {
        if(args.length != 3){
            System.out.println("usage: java RedirectIO stdinfile " +
                "stdoutfile stderrfile");
            return;
        }
        File infile = new File(args[0]);
        if(!infile.exists()){
            try {
                infile.createNewFile();
                try(FileOutputStream fos = new FileOutputStream(infile)){
                    fos.write("hello".getBytes());
                }catch (IOException e){
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.setIn(new FileInputStream(args[0]));

        File outfile = new File(args[1]);
        if(!outfile.exists()){
            outfile.createNewFile();
        }
        System.setOut(new PrintStream(args[1]));

        File errfile = new File(args[2]);
        if(!errfile.exists()){
            errfile.createNewFile();
        }
        System.setErr(new PrintStream(args[2]));

        int b;
        while ((b = System.in.read()) != -1){
            System.out.println(b);
        }
        System.err.println("redirect to error output");
    }
}
