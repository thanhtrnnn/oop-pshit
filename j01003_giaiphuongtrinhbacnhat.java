import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j01003_giaiphuongtrinhbacnhat {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        double a = sc.dint(),
               b = sc.dint();

        if (a == 0) {
            System.out.println(b == 0 ? "VSN" : "VN");
        } else {
            System.out.printf("%.2f\n", -b/a);
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