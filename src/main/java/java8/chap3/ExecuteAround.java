package java8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lixianch on 2017/12/6.
 */
public class ExecuteAround {
    public static void main(String[] args) throws IOException {
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);
    }
    public static String processFileLimited() throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("E:\\Source\\java\\src\\main\\java\\java8\\chap3\\data.txt"))) {
            return br.readLine();
        }
    }


    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("E:\\Source\\java\\src\\main\\java\\java8\\chap3\\data.txt"))){
            return p.process(br);
        }

    }

    public interface BufferedReaderProcessor{
        public String process(BufferedReader b) throws IOException;

    }
}
