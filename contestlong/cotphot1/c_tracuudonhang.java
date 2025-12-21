import java.io.*;
import java.util.*;

public class c_tracuudonhang {
    static class bill {
        String ten, type, ma, stt;
        Long base, slg, giam, total;
        public bill(String ten, String ma, Long base, Long slg) {
            this.ten = ten;
            this.ma = ma;
            this.type = ma.substring(4,5);
            this.stt = ma.substring(1, 4);
            this.base = base;
            this.slg = slg;
            this.total = base * slg;
            this.giam = (type.equals("1")) ? (long)(total * 0.5) : (long)(total * 0.3);
            this.total -= giam;
        }

        @Override
        public String toString() {
            return ten + " " + ma + " " + stt + " " + giam + " " + total;
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
        ArrayList<bill> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            a.add(new bill(sc.nextLine(), sc.next(), sc.nextLong(), sc.nextLong()));

        }
        a.sort((o1, o2) -> { return (o1.ma != o2.ma) ? o2.total.compareTo(o1.total) : o1.ma.compareTo(o2.ma); });
        a.forEach(System.out::println);
        sc.close();
    }
}