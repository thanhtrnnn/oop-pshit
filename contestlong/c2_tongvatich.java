import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class c2_tongvatich {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("DATA.in");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("DATA.out"));
        }
        Scanner sc = new Scanner(System.in);

        BigInteger sum = BigInteger.ZERO, prod = BigInteger.ONE;
        while (sc.hasNext()) {
            BigInteger x = new BigInteger(sc.next());
            sum = sum.add(x);
            prod = prod.multiply(x);
        }
        System.out.println(sum);
        System.out.println(prod);
        sc.close();
    }
}