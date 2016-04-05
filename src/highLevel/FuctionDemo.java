package highLevel;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.BinaryOperator;



/**
 * Created by lixiaoning on 16/4/5.
 */

class Student{

    String firstName;

    String lastName;

    Double grade;

    Double feeDiscount = 0.0;

    Double baseFee = 20000.0;

    public Student(String firstName, String lastName, Double grade) {

        this.firstName = firstName;

        this.lastName = lastName;

        this.grade = grade;
    }

    public void printFee(){

        Double newFee = baseFee - ((baseFee * feeDiscount) / 100);

        System.out.println("The fee after discount: " + newFee);

    }

}


public class FuctionDemo {

    public static Student updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){

        //Use the predicate to decide when to update the discount.

        if ( predicate.test(student)){

            //Use the consumer to update the discount value.

            consumer.accept(student);
        }

        return student;

    }


    public static void main(String[] args) {
        Student student1 = new Student("Ashok","Kumar", 9.5);
        student1 = updateStudentFee(student1,
                //Lambda expression for Predicate interface
                student -> student.grade > 8.5,
                //Lambda expression for Consumer inerface
                student -> student.feeDiscount = 30.0);
        student1.printFee();

        Student student2 = new Student("Rajat","Verma", 8.0);

        student2 = updateStudentFee(student2,
                student -> student.grade >= 8,
                student -> student.feeDiscount = 20.0);
            student2.printFee();


        // Function<T, R> -T作为输入，返回的R作为输出
        Function<String,String> function = (x) -> {System.out.print(x+": ");return "Function";};
        System.out.println(function.apply("hello world"));

        //Predicate<T> -T作为输入，返回的boolean值作为输出
        Predicate<String> pre = (x) ->{System.out.print(x);return false;};
        System.out.println(": "+pre.test("hello World"));

        //Consumer<T> - T作为输入，执行某种动作但没有返回值
        Consumer<String> con = (x) -> {System.out.println(x);};
        con.accept("hello world");

        //Supplier<T> - 没有任何输入，返回T
        Supplier<String> supp = () -> {return "Supplier";};
        System.out.println(supp.get());

        //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
        BinaryOperator<String> bina = (x,y) ->{System.out.print(x+" "+y);return "BinaryOperator";};
        System.out.println("  "+bina.apply("hello ","world"));
    }
}
