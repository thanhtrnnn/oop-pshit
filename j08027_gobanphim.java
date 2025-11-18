import java.io.*;
import java.util.*;

public class j08027_gobanphim {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        String s = sc.readline(), res = "";
        int n = s.length();
        Stack<Character> text = new Stack<>(), buffer = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // move left
            if (c == '<') {
                if (!text.isEmpty()) 
                    buffer.push(text.pop());
            // move right
            } else if (c == '>') {
                if (!buffer.isEmpty()) 
                    text.push(buffer.pop());
            // backspace
            } else if (c == '-') {
                if (!text.isEmpty()) 
                    text.pop();
            // normal character
            } else {
                text.push(c);
            }
        }

        while (!buffer.isEmpty()) 
            text.push(buffer.pop());
        res = text.toString().replaceAll("[\\[\\], ]", "");
        System.out.println(res);
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