import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j01013_tonguocso1 {
    static long[] f = new long[2000001];
    static int[] spf = new int[2000001];
    static void sieve() {
        for (int i = 1; i < spf.length; i++)
            spf[i] = i;
        for (int i = 2; i * i < spf.length; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < spf.length; j += i) {
                    if (spf[j] == j) 
                        spf[j] = i;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        // SOLUTION 1
        for (int i = 0; i < 2000001; i++) {
            f[i] = 0;
            Boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    f[i] = f[j] + f[i / j];
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                f[i] = i;
        }

        // SOLUTION 2
        // sieve();
        FastScanner sc = new FastScanner();
        int t = sc.nint();
        long s = 0;
        while (t-- > 0) {
            int n = sc.nint();
            s += f[n];
            // while (n > 1) {
            //     s += spf[n];
            //     n /= spf[n];
            // }
        }

        System.out.print(s);
    }

    static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st = new StringTokenizer("");

        FastScanner(InputStream in) {
            this.br = new BufferedReader(new InputStreamReader(in));
        }

        FastScanner() { this(System.in); }

        String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return st.nextToken();
        }

        int nint() { return Integer.parseInt(next()); }
        long lint() { return Long.parseLong(next());}
        double dint() { return Double.parseDouble(next()); }

        String readline() {
            String s = "";
            try {
                String t = br.readLine();
                s = (t == null) ? "" : t.trim();
            } catch (IOException e) {}
            return s;
        }

        int[] aint() {
            String s = readline();
            if (s.isEmpty()) return new int[0];
            return Arrays.stream(s.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        boolean hasNext() {
            if (st.hasMoreTokens()) return true;
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    // normalize: split by non-alphanumeric
                    line = line.replaceAll("[^A-Za-z0-9]+", " ");
                    st = new StringTokenizer(line);
                    if (st.hasMoreTokens()) return true;
                }
            } catch (IOException e) {
                return false;
            }
            return false;
        }
    }
}
