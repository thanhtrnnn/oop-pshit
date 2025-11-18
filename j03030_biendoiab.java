import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j03030_biendoiab {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        // min steps to full 'A' string
        String s = sc.next();
        Integer n = s.length();
        int[] dpA = new int[n + 1]; // dpA[i]: min steps to make s[0..i-1] all 'A'
        int[] dpB = new int[n + 1]; // dpB[i]: min steps to make s[0..i-1] all 'B'

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'A') {
                dpA[i] = Math.min(dpA[i - 1], dpB[i - 1] + 1);
                dpB[i] = Math.min(dpA[i - 1] + 1, dpB[i - 1] + 1);
            } else {
                dpA[i] = Math.min(dpA[i - 1] + 1, dpB[i - 1] + 1);
                dpB[i] = Math.min(dpA[i - 1] + 1, dpB[i - 1]);
            }
        }

        System.out.println(dpA[n]);
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