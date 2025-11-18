import java.io.*;
import java.util.*;

public class j08022_phantubenphaidautienlonhon {
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
            int res[] = new int[n];

            // monotonic stack, decreasing order from top
            Stack<Integer> st = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                if (st.isEmpty()) {
                    res[i] = -1; // no greater element in RHS
                    st.push(a[i]);
                } else {
                    // pop smaller elements
                    while (!st.isEmpty() && st.peek() <= a[i]) {
                        st.pop();
                    }
                    // if stack is empty, no greater element found
                    res[i] = st.isEmpty() ? -1 : st.peek();
                    st.push(a[i]);
                }
            }
            sc.print(res);
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

        void print(int[] a) {
            System.out.println(Arrays.toString(a).replaceAll("[\\[\\],]", ""));
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