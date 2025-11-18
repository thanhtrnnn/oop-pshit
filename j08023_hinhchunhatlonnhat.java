import java.io.*;
import java.util.*;

public class j08023_hinhchunhatlonnhat {
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
            int a[] = sc.aint();
            long[] l = new long[n], r = new long[n];
            buildMin(a, l, 0, n, -1);
            buildMin(a, r, n - 1, -1, n);

            long res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, (long)a[i] * (r[i] - l[i] - 1));
            }
            System.out.println(res);
        }
    }

    static void buildMin(int[] a, long[] x, int start, int end, int defaultValue) {
        Stack<Integer> st = new Stack<>();
        for (int i = start; i != end; i += (start < end) ? 1 : -1) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            x[i] = (st.isEmpty()) ? defaultValue : st.peek();
            st.push(i);
        }
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