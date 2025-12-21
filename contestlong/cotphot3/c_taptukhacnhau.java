import java.io.*;
import java.util.*;

public class c_taptukhacnhau {
    static class WordSet {
        private TreeSet<String> set = new TreeSet<>();
        public WordSet() { this.set = new TreeSet<>(); }

        public WordSet(String in) {
            String words[] = in.trim().toLowerCase().split("\\s+");
            for (String x : words) {
                set.add(x);
            }
        }

        public WordSet union(WordSet o) {
            WordSet u = new WordSet();
            u.getSet().addAll(getSet());
            u.getSet().addAll(o.getSet());
            return u;
        }
        public WordSet intersection(WordSet o) {
            WordSet u = new WordSet();
            u.getSet().addAll(getSet());
            u.getSet().retainAll(o.getSet());
            return u;
        }
        public Set<String> getSet() {
            return set;
        }
        @Override
        public String toString() {
            return String.join(" ", set);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
        Scanner in = new Scanner(new File("VANBAN.in"));
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
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