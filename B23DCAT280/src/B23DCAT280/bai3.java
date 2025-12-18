package B23DCAT280;

import java.io.*;
import java.util.*;

public class bai3 {

    static class MatHang {

        String code, name, unit;
        long mua, ban;

        public MatHang(int i, String n, String m, long x, long y) {
            code = "MH" + String.format("%03d", i);
            name = n;
            unit = m;
            mua = x;
            ban = y;
        }

        public boolean match(String c) {
            return c.startsWith(code);
        }
    }

    static class KhachHang {

        String code, name, gender, date, address;

        public KhachHang(int i, String n, String g, String d, String a) {
            code = "KH" + String.format("%03d", i);
            name = n;
            gender = g;
            date = d;
            address = a;
        }

        public boolean match(String c) {
            return c.startsWith(code);
        }

    }

    static class HoaDon {

        MatHang s;
        String code;
        KhachHang p;
        long profit, sum, cnt;

        public HoaDon(int i, MatHang a, KhachHang b, long cnt) {
            code = "HD" + String.format("%03d", i);
            s = a;
            p = b;
            this.cnt = cnt;
            sum = s.ban * cnt;
            profit = s.ban * cnt - s.mua * cnt;
        }

        @Override
        public String toString() {
            return code + ' ' + p.name + ' ' + p.address + ' ' + s.name + ' ' + cnt + ' ' + sum + ' ' + profit;
        }
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream(outputFile));
        }
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<KhachHang> khs = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            khs.add(new KhachHang(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        int m = sc.nextInt();
        ArrayList<MatHang> mhs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            mhs.add(new MatHang(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong()));
        }

        int t = sc.nextInt();
        ArrayList<HoaDon> hds = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String maKH = sc.next(), maMH = sc.next();
            long cnt = sc.nextLong();
            MatHang s = mhs.get(0);
            KhachHang p = khs.get(0);

            for (int j = 0; j < n; j++) {
                if (khs.get(j).match(maKH)) {
                    p = khs.get(j);
                }
            }
            for (int j = 0; j < m; j++) {
                if (mhs.get(j).match(maMH)) {
                    s = mhs.get(j);
                }
            }
            hds.add(new HoaDon(i + 1, s, p, cnt));
        }
        
        hds.sort((x, y) -> (int)(y.profit - x.profit));
        hds.forEach(System.out::println);
    }
}
