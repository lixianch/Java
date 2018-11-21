package pwd;

/**
 * Created by lixianch on 2018/9/30.
 */
import java.io.*;
import java.util.List;
import java.util.Scanner;

import static pwd.ElementConstants.*;
public class PWDGenerator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        BufferedWriter bw= new BufferedWriter(new FileWriter("D://pwd.txt"));
        if(input.equals("1")){
            //3汉字姓名全拼+出生年份
            name3YMD(SURN, nameList, nameList, YEAR, MONTH, DAY,bw);
            System.out.println("3汉字姓名拼音全拼+出生年份密码生成完成！");
        } else if(input.equals("2")){
            name2YMD(SURN, nameList, nameList, YEAR, MONTH, DAY);
            System.out.println("2汉字姓名拼音全拼+出生年份密码生成完成！");
        }else if(input.equals("3")){
            //常用数字组合
            makePsd1(MOST_USE);
            //常用数字组合+常用特殊字符
            makePsd2(MOST_USE, MOST_SIN);

            //姓+其他组合
//            makePsd3(SURN, YEAR, MOST_SIN);//姓+年+特殊符合
//            makePsd2(SURN, MOST_USE);//姓+常用数字组合
//            makePsd3(SURN, MOST_USE, MOST_SIN);//姓+常用数字+特殊符号
//            makePsd4(SURN, YEAR, MONTH, DAY);//姓+年+月+日
//            makePsd4(SURN, MONTH, DAY, MOST_SIN);//姓+月+日+特殊字符
//
//            //名字首字母（姓+1字名、不带姓2字名）+其他组合
//            makePsd3(FNAME2, FNAME2, MOST_USE);//2字母+常用数字
//            makePsd4(FNAME2, FNAME2, MOST_USE, MOST_SIN);//2字母+常用数字组合+常用特殊字符
//            makePsd3(FNAME2, FNAME2, YEAR);//2字母+年
//            makePsd4(FNAME2, FNAME2, MONTH, DAY);//2字母+月+日
//            makePsd5(FNAME2, FNAME2, MONTH, DAY, MOST_SIN);//2字母+月+日+特殊字符
//            makePsd5(FNAME2, FNAME2, YEAR, MONTH, DAY);//2字母+年+月+日
//
//            //名字首字母（姓+2字名）+其他组合
//            makePsd4(FNAME2, FNAME2, FNAME2, MOST_USE);//3字母+常用数字组合
//            makePsd5(FNAME2, FNAME2, FNAME2, MOST_USE, MOST_SIN);//3字母+常用数字组合+常用特殊字符
//            makePsd4(FNAME2, FNAME2, FNAME2, YEAR);//3字母+年
//            makePsd5(FNAME2, FNAME2, FNAME2, YEAR, MOST_SIN);//3字母+年+特殊字符
//            makePsd5(FNAME2, FNAME2, FNAME2, MONTH, DAY);//3字母+月+日
//            makePsd6(FNAME2, FNAME2, FNAME2, MONTH, DAY, MOST_SIN);//3字母+月+日+特殊字符
//            makePsd6(FNAME2, FNAME2, FNAME2, YEAR, MONTH, DAY);//3字母+年+月+日
            System.out.println("超级密码生成完毕！");
        }

        bw.close();
    }

    private static void makePsd2(List<String> mostUse, List<String> mostSin) {
    }

    private static void makePsd1(List<String> mostUse) {
    }

    private static void name2YMD(List<String> surn, List<String> nameList, List<String> nameList1, List<String> year, List<String> month, List<String> day) {
    }

    private static void name3YMD(List<String> surn, List<String> nameList, List<String> nameList1, List<String> year, List<String> month, List<String> day, BufferedWriter bw) throws IOException {
        StringBuilder sb = null;
        for (String s : surn) {
            sb = new StringBuilder();
            sb.append(s);
            for (String n1 : nameList) {
                sb.append(n1);
                for (String n2 : nameList1) {
                    sb.append(n2);
                    for (String y : year) {
                        sb.append(y);
                        for (String m : month) {
                            sb.append(m);
                            for (String d : day) {
                                sb.append(d);
                                bw.write(sb.toString());
                                bw.newLine();
                            }
                        }
                    }
                }
            }
        }
    }
}
