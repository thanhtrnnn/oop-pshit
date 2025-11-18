import java.io.*;
import java.util.*;

public class j05037_tinhgiaban2 {
    static class item {
        private String ma, ten, dv;
        private Long dongia, soluong, vanchuyen, thanhtien, giaban;
        public item(int id, String ten, String dv, Long dongia, Long soluong) {
            this.ma = String.format("MH%02d", id);
            this.ten = ten;
            this.dv = dv;
            this.dongia = dongia;
            this.soluong = soluong;
            this.vanchuyen = Math.round(dongia * soluong * 0.05);
            this.thanhtien = dongia * soluong + this.vanchuyen;
            this.giaban = (long) Math.ceil((this.thanhtien * 1.02 / soluong) / 100.0) * 100;
        }

        @Override
        public String toString() {
            return this.ma + " " + this.ten + " " + this.dv + " " + this.vanchuyen + " " + this.thanhtien + " " + this.giaban;
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
        ArrayList<item> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            a.add(new item(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong()));
        }

        a.sort((o1, o2) -> Long.compare(o2.giaban, o1.giaban));
        a.forEach(x -> System.out.println(x));
        sc.close();
    }
}