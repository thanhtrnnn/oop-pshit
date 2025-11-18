import java.io.*;
import java.util.*;

public class j03006_sodep1 {
    static String check(String s) {
        return (s.replaceAll("[13579]", "").length() == s.length() && 
                s.equals(new StringBuilder(s).reverse().toString())) ? "YES" : "NO";
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
            String s = sc.next();
            System.out.println(check(s));
        }
        sc.close();
    }
}
