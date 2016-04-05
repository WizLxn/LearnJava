package LearnAndTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lixiaoning on 16/4/4.
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {

        ////////////读取字符
//        char c;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter characters, 'q' to quit.");
//        do {
//            c = (char)br.read();
//            System.out.println(c);
//        } while (c != 'q');

        ////////////////读取字符串
//        String str;
//        System.out.println("Enter lines of text.");
//        System.out.println("Enter 'end' to quit.");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        do {
//            str = br.readLine();
//            System.out.println(str);
//        } while (!str.equals("end"));

        //////////////////输出字符  write()方法不经常使用，因为print()和println()方法用起来更为方便
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
    }
}
