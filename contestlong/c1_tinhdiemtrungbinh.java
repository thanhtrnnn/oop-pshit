import java.io.*;
import java.util.*;

public class c1_tinhdiemtrungbinh {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double a[] = new double[n];
        double xum = 0, mx = -1, mn = 11;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            xum += a[i];
            if (a[i] > mx) mx = a[i];
            if (a[i] < mn) mn = a[i];
        }
        int cntmx = 0, cntmn = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == mx) cntmx++;
            if (a[i] == mn) cntmn++;
        }
        System.out.println(String.format("%.2f", (xum - mx * cntmx - mn * cntmn) / (n - cntmx - cntmn)));
        sc.close();
    }
}
