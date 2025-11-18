import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class j03015_hieusonguyenlon2 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        BigInteger a = sc.nextBigInteger(), b = sc.nextBigInteger();
        System.out.println(a.subtract(b));
        sc.close();
    }
}
