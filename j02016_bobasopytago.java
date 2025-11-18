import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j02016_bobasopytago {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        int t = sc.nint();
        while (t-- > 0) {
            int n = sc.nint();
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.lint();
                a[i] *= a[i];
            }
            Arrays.sort(a);
            
            boolean found = false;
            for (int i = n - 1; i >= 2; i--) {
                int j = 0, k = i - 1;
                while (j < k) {
                    if (a[j] + a[k] == a[i]) {
                        found = true;
                        break;
                    } else if (a[j] + a[k] < a[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            System.out.println(found ? "YES" : "NO");
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nint() { return Integer.parseInt(next()); }
        long lint() { return Long.parseLong(next());}
        double dint() { return Double.parseDouble(next()); }

        String readline() {
            String s = "";
            try {
                s = br.readLine().trim();
            } catch (IOException e) {}
            return s;
        }

        int[] aint() {
            String s = readline();
            return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}   