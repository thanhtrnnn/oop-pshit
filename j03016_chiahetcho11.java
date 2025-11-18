import java.io.*;
import java.util.*;

public class j03016_chiahetcho11 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String n = sc.next();
            int lul = 0;
            for (int i = 0; i < n.length(); i++) {
                lul += (i % 2 == 0 ? 1 : -1) * (n.charAt(i) - '0');
            }
            System.out.println(lul % 11 == 0 ? "1" : "0");
        }
        sc.close();
    }
}