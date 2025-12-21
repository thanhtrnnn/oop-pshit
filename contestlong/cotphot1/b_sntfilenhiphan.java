import java.io.*;
import java.util.*;

public class b_sntfilenhiphan {
    static boolean[] isPrime = new boolean[1000001];
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        // FastScanner sc = new FastScanner();

        sieve();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("DATA.in")));
        @SuppressWarnings("unchecked")
        ArrayList<Integer> a = (ArrayList<Integer>) ois.readObject();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> b = (ArrayList<Integer>) ois.readObject();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        for (Integer x : a) {
            if (isPrime[x])
                map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Integer x : b) {
            if (isPrime[x])
                map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val1 = entry.getValue();
            int val2 = map2.getOrDefault(key, 0);
            if (val2 > 0) {
                System.out.println(key + " " + val1 + " " + val2);
            }
        }

        ois.close();
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