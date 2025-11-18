import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j01025_hinhvuong {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        List<Integer> a1 = Arrays.asList(sc.nint(), sc.nint());
        List<Integer> a2 = Arrays.asList(sc.nint(), sc.nint());
        List<Integer> b1 = Arrays.asList(sc.nint(), sc.nint());
        List<Integer> b2 = Arrays.asList(sc.nint(), sc.nint());

        int minx = Collections.min(Arrays.asList(a1.get(0), a2.get(0), b1.get(0), b2.get(0)));
        int miny = Collections.min(Arrays.asList(a1.get(1), a2.get(1), b1.get(1), b2.get(1)));
        int maxx = Collections.max(Arrays.asList(a1.get(0), a2.get(0), b1.get(0), b2.get(0)));
        int maxy = Collections.max(Arrays.asList(a1.get(1), a2.get(1), b1.get(1), b2.get(1)));
        int dist = Math.max(maxx - minx, maxy - miny);
        
        System.out.println(dist * dist);
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