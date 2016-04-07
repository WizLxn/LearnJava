package containers;

import java.util.Vector;

/**
 * Created by lixiaoning on 16/4/5.
 */
public class VectorDemo {

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(12);
        System.out.println(vector.lastElement() instanceof Integer);
    }
}
