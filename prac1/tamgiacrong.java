import java.io.*;
import java.util.*;

public class tamgiacrong {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] innerGap = new int[n];
        for (int i = 0; i < n - 1; i++) {
            innerGap[n - i - 2] = 2 * i + 1;
        }
        // System.out.println(Arrays.toString(innerGap));
        for (int i = -n + 1; i <= 0; i++) {
            for (int j = 0; j < Math.abs(i); j++) {
                System.out.print(" ");
            }
            System.out.println((i < 0) ? 
                "*" + repeat(" ", innerGap[Math.abs(i)]) + (Math.abs(i) == n - 1 ? "" : "*")
                : repeat("*", 2 * n - 1));
        }
        sc.close();
    }

    static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < times; k++) sb.append(s);
        return sb.toString();
    }
}