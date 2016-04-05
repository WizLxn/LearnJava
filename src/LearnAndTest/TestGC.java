package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/3.
 */

/*
http://blog.csdn.net/zsuguangh/article/details/6429592
在普通的清除工作中，为清除一个对象，那个对象的用户必须在希望进行清除的地点调用一个清除方法。这与C++"析构函数"的概念稍有抵触。在C++中，所有对象都会破坏（清除）。或者换句话说，所有对象都"应该"破坏。若将C++对象创建成一个本地对象，比如在堆栈中创建（在Java中是不可能的，Java都在堆中），那么清除或破坏工作就会在"结束花括号"所代表的、创建这个对象的作用域的末尾进行。若对象是用new创建的（类似于Java），那么当程序员调用C++的 delete命令时（Java没有这个命令），就会调用相应的析构函数。若程序员忘记了，那么永远不会调用析构函数，我们最终得到的将是一个内存"漏洞"，另外还包括对象的其他部分永远不会得到清除。
相反，Java不允许我们创建本地（局部）对象--无论如何都要使用new。但在Java中，没有"delete"命令来释放对象，因为垃圾回收器会帮助我们自动释放存储空间。所以如果站在比较简化的立场，我们可以说正是由于存在垃圾回收机制，所以Java没有析构函数。然而，随着以后学习的深入，就会知道垃圾收集器的存在并不能完全消除对析构函数的需要，或者说不能消除对析构函数代表的那种机制的需要（原因见下一段。另外finalize()函数是在垃圾回收器准备释放对象占用的存储空间的时候被调用的，绝对不能直接调用finalize()，所以应尽量避免用它）。若希望执行除释放存储空间之外的其他某种形式的清除工作，仍然必须调用Java中的一个方法。它等价于C++的析构函数，只是没后者方便。
 */

public class TestGC {
    public static void main(String[] args) {
        new TestGC();
        //NOTE:主动的垃圾回收,JAVA中没有析构函数的概念,如需要清理资源需要override Object这个类中的finalize()方法
        //一旦垃圾回收器准备好释放对象占用的存储空间，首先会去调用finalize()方法进行一些必要的清理工作。
//        java -verbosegc LearnAndTest.TestGC
//        [GC (System.gc())  1996K->520K(125952K), 0.0009925 secs]
//        [Full GC (System.gc())  520K->428K(125952K), 0.0043809 secs]

        System.gc();
        System.runFinalization();


        ///

        if (args.length == 0) {
            System.err.println("Usage: /n" + "java Garbage before/n or:/n" + "java Garbage after");
            return;
        }
        while (!Chair.f) {
            new Chair();
            new String("To take up space");
        }
        System.out.println("After all Chairs have been created:/n" + "total created = " + Chair.created + "， total finalized = " + Chair.finalized);
        if (args[0].equals("before")) {
            System.out.println("gc():");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println("bye!");
        if (args[0].equals("after"))
            System.runFinalization();
    }
}


class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;

    Chair() {
        i = ++created;
        if (created == 47) System.out.println("Created 47");
    }

    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println("Beginning to finalize after " + created + " Chairs have been created");
        }
        if (i == 47) {
            System.out.println("Finalizing Chair #47， " + "Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized >= created) System.out.println("All " + finalized + " finalized");
    }
}

