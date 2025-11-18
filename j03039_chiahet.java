import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class j03039_chiahet {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();
        while(t-- > 0){
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            System.out.println((a.mod(b).equals(BigInteger.ZERO) || b.mod(a).equals(BigInteger.ZERO)) ? "YES" : "NO");
        }
        sc.close();
    }
}
