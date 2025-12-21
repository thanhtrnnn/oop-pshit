import java.io.*;
import java.util.*;

public class b_ghepma {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        // }
        // Scanner sc = new Scanner(System.in);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        @SuppressWarnings("unchecked")
        ArrayList<String> o1 = (ArrayList<String>) ois.readObject();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> o2 = (ArrayList<Integer>) ois.readObject();

        TreeSet<String> a = new TreeSet<>(o1);
        TreeSet<Integer> b = new TreeSet<>(o2);

        for (String x : a) {
            for (Integer y : b) {
                System.out.println(x + y);
            }
        }
    }
}