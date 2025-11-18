import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class j07021_chuanhoaxauhotentrongfile {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("DATA.in");
        Scanner sc = new Scanner(inputFile);

        while (true) {
            String[] parts = sc.nextLine().trim().toLowerCase().split("[' ']+");
            if (parts.length == 0) 
                continue;
            if (parts[0].equals("end")) {
                sc.close();
                break;
            }

            StringBuilder finalName = new StringBuilder();
            for (String part : parts) {
                finalName.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1)).append(" ");
            }
            System.out.println(finalName.toString().trim());
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