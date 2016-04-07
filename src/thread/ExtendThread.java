package thread;

/**
 * Created by lixiaoning on 16/4/7.
 */

class NewThread1 extends Thread {
    NewThread1() {
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}
//NOTE:主线程退出之后子线程仍然可以继续运行
public class ExtendThread {
    public static void main(String[] args) {
        new NewThread1();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
