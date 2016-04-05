package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/2.
 */
class FreshJuice {
    enum FreshJuiceSize {SMALL, MEDUIM, LARGE}
    FreshJuiceSize size;
}


public class CEnum {
    public static void main(String []args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.SMALL;
        //NOTE: java 中enum类型默认不能和int类型进行转换, 使用print输出时显示的是枚举的名称
        System.out.print(juice.size);
    }
}