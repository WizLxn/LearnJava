package LearnAndTest;

/**
 * Created by lixiaoning on 16/4/5.
 */
public class UnsignedData {

    static public long getUnsignedInt(int data) {
        return data & 0x0FFFFFFF;
    }

    public static void main(String[] args) {
        int positive = 12321;
        int nagative = -3435;

        long pos = getUnsignedInt(positive);
        long nag = getUnsignedInt(nagative);

        System.out.println(pos);
        System.out.println(nag);
    }
}
