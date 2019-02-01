package io;

import java.io.*;
import java.util.Map;

/**
 * Created by lixianch on 2019/1/31.
 */
public class ScrambledOutputStream extends FilterOutputStream {
    private int[] map;
    public ScrambledOutputStream(OutputStream out,int[] map) {
        super(out);
        this.map = map;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(map[b]);
    }

    public static void main(String[] args) throws IOException{
        PrintStream out = System.out;
        int[] map = new int[]{65,66,67,68,69,70,71,72,73,74};
        ScrambledOutputStream scrambledOutputStream = new ScrambledOutputStream(out, map);
        for (int i = 0; i < 10; i++) {
            scrambledOutputStream.write(i);
            scrambledOutputStream.flush();
        }
    }
}
