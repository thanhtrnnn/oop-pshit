import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j03010_diachiemail {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        FastScanner sc = new FastScanner();

        int t = sc.nint();
        HashMap<String, Integer> emailDB = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] name = sc.readline().toLowerCase().split("[' ']+");
            if (name.length == 0)
                continue;
            
            String mail = name[name.length - 1];
            for (int i = 0; i < name.length - 1; i++) 
                mail += name[i].charAt(0);

            if (emailDB.containsKey(mail)) {
                emailDB.put(mail, emailDB.get(mail) + 1);
                mail += emailDB.get(mail);
            } else {
                emailDB.put(mail, 1);
            }

            System.out.println(mail + "@ptit.edu.vn");
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

        boolean hasNextLine() {
            try {
                return br.ready();
            } catch (IOException e) {
                return false;
            }
        }
    }
}