import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j07004_sokhacnhautrongfile1 {
    public static void main(String[] args) throws IOException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        File inputFile = new File("DATA.in");
        try {
            // System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            // System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
            // Scanner sc = new Scanner(inputFile);
            Scanner sc = new Scanner(inputFile);
            HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
            while (sc.hasNext()) {
                int n = sc.nextInt();
                mp.put(n, mp.getOrDefault(n, 0) + 1);
            }
            mp.forEach((key, value) -> {
                System.out.printf("%d %d\n", key, value);
            });
        } catch (FileNotFoundException e) {}
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

        boolean hasNext() {
            return st.hasMoreTokens();
        }
    }
}