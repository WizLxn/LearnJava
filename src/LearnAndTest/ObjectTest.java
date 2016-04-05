package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/2.
 */

import TestPackage.ParentClass;

class TestControl extends ParentClass {

    void testControl() {
        //NOTE:如果子类和父类不在同一个包中,子类看不到父类的default修饰符指定的变量(在同一个包中时可以看到),protected修饰符指定的变量可以看到
        //NOTE:protected生命的变量可以被同一个包中的其他对象访问,但是接口的成员变量和成员方法不能声明为protected。
        //NOTE:父类中声明为public的方法在子类中也必须为public,父类中声明为protected的方法在子类中要么声明为protected，要么声明为public,不能声明为private。
        aProtectedCValue = true;
        aPublicCValue = true;
    }
}

class Parent {

    boolean aDefaultCValue;


    void parentFunc1() {
        System.out.println("parentFunc1");
    }

    void parentFunc2() {
        System.out.println("parentFunc2");
    }

    static void staticFoo() {
        System.out.println("Static foo in parent");
    }

    static void anotherStaticFoo() {
        System.out.println("Another static foo in parent");
    }
}

    /*
    方法的覆盖规则
参数列表必须完全与被重写方法的相同；
返回类型必须完全与被重写方法的返回类型相同；
访问权限不能比父类中被重写的方法的访问权限更高。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
父类的成员方法只能被它的子类重写。
声明为final的方法不能被重写。
声明为static的方法不能被重写，但是能够被再次声明。
子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。
重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
构造方法不能被重写。
如果不能继承一个方法，则不能重写这个方法。
     */

class Child extends Parent {

    @Override
    void parentFunc1() {
        System.out.println("childFunc1");
        aDefaultCValue = false;
    }

    /* 声明为static的方法不能被覆盖，但是能够被再次声明。此处覆盖了父类的方法
    1.父类的静态方法可以被子类的静态方法覆盖
    2.父类的非静态方法不能被子类的静态方法覆盖
    3.父类的静态方法不能被子类的非表态方法覆盖
    */
    static void staticFoo() {
        System.out.println("Static foo in child");
    }

    static void staticFoo(int abc) {

    }

//    void anotherStaticFoo() {
//        System.out.println("Another static foo in child");
//    }
}

/*
重载规则
被重载的方法必须改变参数列表；
被重载的方法可以改变返回类型；
被重载的方法可以改变访问修饰符；
被重载的方法可以声明新的或更广的检查异常；
方法能够在同一个类中或者在一个子类中被重载。
 */

class ClassWithNoExplicitConstructor {

    //NOTE: 有参构造函数会覆盖默认的无参构造函数

    public ClassWithNoExplicitConstructor() {

    }

    public ClassWithNoExplicitConstructor(int a) {

    }

    void print() {
        System.out.println("ClassWithNoExplicitConstructor");
    }
}

abstract class AbstactClass {
    public abstract void abstractFunc();
}

public class ObjectTest {

    //NOTE:静态成员变量会自动进行初始化,而普通成员变量不会
    private static double employeeSalary;
    private  int abc;

    public static void main(String []args) {
        ClassWithNoExplicitConstructor obj = new ClassWithNoExplicitConstructor();
        obj.print();

        //NOTE: JAVA中对象变量类似指针,可以通过父类型指向一个子类型对象, 调用的方法如果在子类型中有过重载,会执行重载后的方法
        Parent pa = new Child();
        pa.parentFunc1();
        pa.parentFunc2();

        pa.staticFoo();

        //NOTE:可以通过强制类型转换来将父类型对象转换为子类型对象,但转换可能会失败,并抛出异常.转换之前可以使用instanceof判断是否能够转换
        Child cl = (Child)pa;
        cl.parentFunc1();

        Parent pa1 = new Parent();
        Child c2 = pa1 instanceof Child ? ((Child) pa1) : null;
//        Child c2 = (Child)pa1;
        if (c2 != null) {
            c2.parentFunc1();
        }

        System.out.println(cl);
        System.out.println(c2);
        int a = 0;
        System.out.println(a);
        Child c3 = null;
        //NOTE: 实例变量在创建时会默认设置为Null.此编译器禁止直接使用为初始化的对象
        if (c3 == null) {
            System.out.println("Object is null");
        }

        System.out.println(employeeSalary);
        //System.out.println(abc);

        //NOTE:不能直接创建abstract对象
//        AbstactClass ab = new AbstactClass();
    }
}
