package LearnAndTest;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by lixiaoning on 16/4/3.
 */
public class StringDemo {

    public static void main(String []args) {
        //NOTE:通过char[]创建多个字符串对象时,每个对象都是一个数组.
        char[] helloArray = { 'h', 'e', 'l', 'l', 'o'}, abc = {'h', 'e', 'c'};
//        char abc1 = {'h', 'e', 'c'};
        System.out.println(helloArray);
        System.out.println(abc);

        //NOTE:String类是不可改变的.如需对字符串进行很多修改那么应该选择使用StringBuffer & StringBuilder 类
        String helloString = new String(helloArray);
        System.out.println(helloString);
        System.out.println(helloString.replaceAll("l", "q"));
        System.out.println(helloString);
        System.out.println("hello".concat(" world") + "!");

        //NOTE:字符串格式化输出, %d intVar, %f floatVar, %s stringVar

        //NOTE:字符串join的时候null对象会输出null, Note that if an individual element is null, then "null" is added.
        List<String> strings = new LinkedList<>();
        strings.add("Java");
        strings.add("is");
        strings.add("cool");
        strings.add(null);
        String message = String.join(" ", strings);
        System.out.println(message);


        //NOTE:当对字符串进行修改的时候，需要使用StringBuffer和StringBuilder类。
        //NOTE:StringBuilder的方法不是线程安全的,但速度较快.StringBuffer是线程安全的
        StringBuffer sBuffer = new StringBuffer("test");
        sBuffer.append(" String buffer");
        System.out.println(sBuffer);

    }
}
