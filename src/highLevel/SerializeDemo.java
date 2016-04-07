package highLevel;

import java.io.*;

/**
 * Created by lixiaoning on 16/4/6.
 */

class Employee implements java.io.Serializable
{
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}

public class SerializeDemo {

    public static void main(String[] args) {
        ////////
//        Employee e = new Employee();
//        e.name = "Reyan Ali";
//        e.address = "Phokka Kuan, Ambehta Peer";
//        e.SSN = 111222333;
//        e.number = 101;
//
//        try {
//            FileOutputStream fileOut = new FileOutputStream("employee.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(e);
//            out.close();
//            fileOut.close();
//            System.out.println("Serialized data is saved");
//        } catch (IOException i) {
//            i.printStackTrace();
//        }

        ////////////////////
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException c) {
            c.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Desrialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
