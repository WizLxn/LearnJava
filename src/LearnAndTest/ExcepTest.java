package LearnAndTest;

import javax.naming.InsufficientResourcesException;
import java.rmi.RemoteException;

/**
 * Created by lixiaoning on 16/4/4.
 */
public class ExcepTest {
    public static void main(String[] args) {

        int[] a = new int[2];
        try {
            System.out.println("Access element two : " + a[1]);
            System.out.println("Access element three : " + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown : " + e);
            e.printStackTrace();
        } finally {
            a[0] = 6;
            System.out.println("Access element : " + a[0]);
        }
        System.out.println("Out of the block");
    }

    public void deposit(double amout) throws RemoteException
    {
        throw new RemoteException();
    }

    public void withdraw(double amout) throws RemoteException, InsufficientResourcesException
    {
        //
    }
}

class B extends Object {
    void test() {
        //NOTE:在JAVA中所有类都是Object的子类，定义类时可以不显示地声明
        ExcepTest t = new ExcepTest();
        t.equals(this);
    }
}

