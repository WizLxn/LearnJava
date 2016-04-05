package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/3.
 */
public class VarargsDemo {

    //NOTE:可变参数在指定参数类型后加一个省略号(...).一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明
    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }

        System.out.println("The max value is " + result);
    }


    public static void main(String[] args) {
        printMax(34, 3, 3, 2, 57.5);
        printMax(new double[]{1, 2, 3});
    }

}
