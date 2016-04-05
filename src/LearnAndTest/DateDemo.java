package LearnAndTest;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by lixiaoning on 16/4/3.
 */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());

        //使用SimpleDateFormat格式化日期
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(date));

        //使用printf格式化日期
        String str = String.format("Current Date/Time: %tc", date);
        System.out.println(str);

        // 使用toString()显示日期和时间.利用一个格式化字符串指出要被格式化的参数的索引。
        //索引必须紧跟在%后面，而且必须以$结束。
        System.out.printf("%1$s %2$tB %2$td, %2$tY\n",
                "Due date:", date);

        // 显示格式化时间  可以使用<标志。它表明先前被格式化的参数要被再次使用
        System.out.printf("%s %tB %<te, %<tY\n",
                "Due date:", date);

        //解析字符串为时间
        ft = new SimpleDateFormat("yyyy-MM-dd");
        String input = args.length == 0 ? "1818-11-11" : args[0];
        System.out.print(input + "Parse as ");
        Date t;
        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        //sleep休眠
        try {
            System.out.println(new Date());
            Thread.sleep(1000 * 3);
            System.out.println(new Date());
        } catch (Exception e) {
            System.out.println("Got an exception");
        }

        //测量时间
        try {
            long start = System.currentTimeMillis();
            System.out.println(new Date());
            Thread.sleep(5*60*10);
            System.out.println(new Date());
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("Difference is : " + diff);
        } catch (Exception e) {
            System.out.println("Got an exception");
        }

        //Calendar 单例,通过Calendar.getInstance()获取实例.Calendar类实现了公历日历，GregorianCalendar是Calendar类的一个具体实现
        Calendar cl = Calendar.getInstance();
        System.out.println(cl.get(Calendar.MONTH));
    }
}

/*
字母	描述	示例
G	纪元标记	AD
y	四位年份	2001
M	月份	July or 07
d	一个月的日期	10
h	 A.M./P.M. (1~12)格式小时	12
H	一天中的小时 (0~23)	22
m	分钟数	30
s	秒数	55
S	微妙数	234
E	星期几	Tuesday
D	一年中的日子	360
F	一个月中第几周的周几	2 (second Wed. in July)
w	一年中第几周	40
W	一个月中第几周	1
a	A.M./P.M. 标记	PM
k	一天中的小时(1~24)	24
K	 A.M./P.M. (0~11)格式小时	10
z	时区	Eastern Standard Time
'	文字定界符	Delimiter
"	单引号	`
 */

/*
日期和时间转换字符
字符	描述	例子
c	完整的日期和时间	Mon May 04 09:51:52 CDT 2009
F	ISO 8601 格式日期	2004-02-09
D	U.S. 格式日期 (月/日/年)	02/09/2004
T	24小时时间	18:05:19
r	12小时时间	06:05:19 pm
R	24小时时间，不包含秒	18:05
Y	4位年份(包含前导0)	2004
y	年份后2位(包含前导0)	04
C	年份前2位(包含前导0)	20
B	月份全称	February
b	月份简称	Feb
n	2位月份(包含前导0)	02
d	2位日子(包含前导0)	03
e	2位日子(不包含前导0)	9
A	星期全称	Monday
a	星期简称	Mon
j	3位年份(包含前导0)	069
H	2位小时(包含前导0), 00 到 23	18
k	2位小时(不包含前导0),  0 到 23	18
I	2位小时(包含前导0), 01 到 12	06
l	2位小时(不包含前导0),  1 到 12	6
M	2位分钟(包含前导0)	05
S	2位秒数(包含前导0)	19
L	3位毫秒(包含前导0)	047
N	9位纳秒(包含前导0)	047000000
P	大写上下午标志	PM
p	小写上下午标志	pm
z	从GMT的RFC 822数字偏移	-0800
Z	时区	PST
s	自 1970-01-01 00:00:00 GMT的秒数	1078884319
Q	自 1970-01-01 00:00:00 GMT的毫妙	1078884319047
 */