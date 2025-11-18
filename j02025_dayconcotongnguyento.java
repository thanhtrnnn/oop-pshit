import java.util.*;
import java.io.*;

public class j02025_dayconcotongnguyento {
    static boolean isPrime(int x) {
        if (x < 2)
            return false;
        if (x == 2)
            return true;
        if (x % 2 == 0)
            return false;
        for (int i = 3; i <= (int) Math.sqrt(x); i += 2) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
    static void Try(int end, Integer[] a, int sum, String s) {
        if (isPrime(sum)) 
            System.out.println(s);
        for (int i = a.length - 1; i >= end; i--) {
            Try(i + 1, a, sum + a[i], s + a[i] + ' ');
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:\\OneDrive - ptit.edu.vn\\pro\\dsa\\input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:\\OneDrive - ptit.edu.vn\\pro\\dsa\\input.txt"));
            System.setOut(new PrintStream("E:\\OneDrive - ptit.edu.vn\\pro\\dsa\\output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            Arrays.sort(a, Collections.reverseOrder());
            Try(0, a, 0, "");
        }
    }
}
