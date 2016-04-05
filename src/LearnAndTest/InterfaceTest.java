package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/2.
 */

interface AInterface {

    //NOTE:接口中的成员变量会隐式声明为public static final
    boolean boolValue = true;

    void testInterfaceFunc();

    //NOTE:接口中的成员方法会隐私声明为public abstract
    static boolean processOrder() {
        return true;
    }
}

//NOTE:接口可以通过extends继承其他接口,且可以多重继承
interface AnotherInterface extends AInterface {

}

public class InterfaceTest implements AInterface {

    @Override
    public void testInterfaceFunc() {
//        boolValue = false;
    }
}

//没有任何方法的标记接口
interface EmptyInterface {

}
