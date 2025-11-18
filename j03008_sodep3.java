import java.util.*;
import java.io.*;

public class j03008_sodep3 {
    static String nt = "2357";
    static String check(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (nt.indexOf(s.charAt(i)) == -1)
                return "NO";
            if (s.charAt(i) != s.charAt(n - 1 - i)) 
                return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            System.out.println(check(s));
        }
        sc.close();
    }
}
