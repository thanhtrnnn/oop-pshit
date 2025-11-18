import java.io.*;
import java.util.*;

public class j05018_bangdiemhocsinh {
    static class student {
        private String id, name, eval;
        private double[] scores;
        private double avg;

        public student(int id, String name, double[] scores) {
            this.id = String.format("HS%02d", id);
            this.name = name;
            this.scores = scores;
            this.avg = (Arrays.stream(scores).sum() / 12 * 10) / 10.0;
            if (avg >= 9) {
                this.eval = "XUAT SAC";
            } else if (avg >= 8) {
                this.eval = "GIOI";
            } else if (avg >= 7) {
                this.eval = "KHA";
            } else if (avg >= 5) {
                this.eval = "TB";
            } else {
                this.eval = "YEU";
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + String.format("%.1f", avg) + " " + eval;
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        ArrayList<student> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            double score[] = new double[10];
            for (int j = 0; j < 10; j++) {
                score[j] = (j > 1) ? sc.nextDouble() : sc.nextDouble() * 2;
            }
            a.add(new student(i + 1, name, score));
        }

        a.sort((student x, student y) -> {
            if (y.avg != x.avg) {
                return Double.compare(y.avg, x.avg);
            } else {
                return x.id.compareTo(y.id);
            }
        });

        a.forEach(e -> System.out.println(e));
        sc.close();
    }
}