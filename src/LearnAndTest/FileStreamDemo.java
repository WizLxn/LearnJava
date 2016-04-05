package LearnAndTest;

import java.io.*;

/**
 * Created by lixiaoning on 16/4/4.
 */
public class FileStreamDemo {
    public static void main(String[] args) {

        try {
            byte[] bWrite = {85, 105, 58, 40, 5};
            OutputStream os = new FileOutputStream("test.txt");
            for (int i = 0; i < bWrite.length; i++) {
                os.write(bWrite[i]);
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char)is.read() + " ");
            }
            is.close();
        } catch (IOException e) {
            System.out.println("Exception");
        }
    }
}
