import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class j03011_uocsochunglonnhatcuasonguyenlon {
    static BigInteger gcd(BigInteger a, BigInteger b){
        if (b.equals(BigInteger.ZERO)) return a;
        return gcd(b, a.mod(b));
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            BigInteger a = sc.nextBigInteger(), b = sc.nextBigInteger();
            System.out.println(gcd(a, b));
        }
        sc.close();
    }
}
