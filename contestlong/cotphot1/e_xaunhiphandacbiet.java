import java.io.*;
import java.util.*;

public class e_xaunhiphandacbiet {
    static ArrayList<String> res = new ArrayList<>();
    static int n;

    static boolean isEvenPalindrome(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    static void backtrack(String s) {
        if (s.length() == n) {
            if (isEvenPalindrome(s)) res.add(s);
            return;
        } else if (s.length() % 2 == 0) {
            if (isEvenPalindrome(s)) res.add(s);
        }
        backtrack("0" + s + "0");
        backtrack("1" + s + "1");
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        int t = sc.nint();
        while (t-- > 0) {
            n = sc.nint();
            backtrack("");
            System.out.println(res.size());
            res.sort((x, y) -> {
                if (x.length() != y.length()) {
                    return x.length() - y.length();
                } else {
                    return x.compareTo(y);
                }
            });
            res.forEach(e -> System.out.print(e + " "));
            System.out.println();
            res.clear();
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