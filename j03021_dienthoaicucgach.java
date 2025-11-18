import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j03021_dienthoaicucgach {
    static char convert(char x) { // ref
        if ("ABC".indexOf(x) > -1) return '2';
        if ("DEF".indexOf(x) > -1) return '3';
        if ("GHI".indexOf(x) > -1) return '4';
        if ("JKL".indexOf(x) > -1) return '5';
        if ("MNO".indexOf(x) > -1) return '6';
        if ("PQRS".indexOf(x) > -1) return '7';
        if ("TUV".indexOf(x) > -1) return '8';
        return '9';
    }
    
    static char toNumber(char x) {
        return "22233344455566677778889999".charAt(x - 'A');
    }

    static boolean isPalindrome(String s) {
        // basic
        // int n = s.length();
        // for (int i = 0; i < n / 2; i++) {
        //     if (s.charAt(i) != s.charAt(n - 1 - i)) {
        //         return false;
        //     }
        // }
        // return true;

        // fancy that
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        int t = sc.nint();
        while (t-- > 0) {
            String s = sc.readline().toUpperCase();
            // char[] typed = new char[s.length()];
            // for (int i = 0; i < s.length(); i++) {
            //     typed[i] = toNumber(s.charAt(i));
            // }
            StringBuilder typed = new StringBuilder();
            for (int i = 0; i < s.length(); i++) 
                typed.append(toNumber(s.charAt(i)));

            System.out.println(isPalindrome(new String(typed)) ? "YES" : "NO");
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