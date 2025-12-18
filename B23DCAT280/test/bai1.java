package B23DCAT280;

import java.io.*;
import java.util.*;

public class bai1 {

    static class SinhVien {

        private String id, name, lop, mail;

        private String chuanTen(String s) {
            String parts[] = s.trim().toLowerCase().split("\\s+");
            String res = "";
            for (int i = 0; i < parts.length; i++) {
                res += Character.toString(parts[i].charAt(0)).toUpperCase() + parts[i].substring(1) + " ";
            }
            return res.trim();
        }

        public SinhVien(String id, String name, String lop, String mail) {
            this.id = id;
            this.name = chuanTen(name);
            this.lop = lop;
            this.mail = mail;
        }

    }

    static class MonHoc {

        private String id, name;
        private int tin;

        public MonHoc(String id, String name, int tin) {
            this.id = id;
            this.name = name;
            this.tin = tin;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    static class BangDiem {

        MonHoc mh;
        SinhVien sv;
        private Double point;

        private String round(double p) {
            return ((int) p == p) ? String.format("%d", (int) p) : String.format("%s", p);
        }

        public BangDiem(SinhVien sv, MonHoc mh, Double point) {
            this.mh = mh;
            this.sv = sv;
            this.point = point;
        }

        @Override
        public String toString() {
            return sv.id + " " + sv.name + " " + sv.lop + " " + round(point);
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sv = new Scanner(new File("SINHVIEN.in"));
        Scanner mh = new Scanner(new File("MONHOC.in"));
        Scanner bd = new Scanner(new File("BANGDIEM.in"));
        HashMap<String, SinhVien> idToSV = new HashMap<>();
        HashMap<String, MonHoc> idToMH = new HashMap<>();

        int t = sv.nextInt();
        sv.nextLine();
        for (int i = 0; i < t; i++) {
            SinhVien x = new SinhVien(sv.nextLine(), sv.nextLine(), sv.nextLine(), sv.nextLine());
            idToSV.put(x.id, x);
        }

        t = mh.nextInt();
        for (int i = 0; i < t; i++) {
            mh.nextLine();
            MonHoc x = new MonHoc(mh.nextLine(), mh.nextLine(), mh.nextInt());
            idToMH.put(x.id, x);
        }

        t = bd.nextInt();
        ArrayList<BangDiem> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            a.add(new BangDiem(idToSV.get(bd.next()), idToMH.get(bd.next()), bd.nextDouble()));
        }

        a.sort((o1, o2) -> {
            return (o1.point == o2.point) ? o1.sv.id.compareTo(o2.sv.id) : o2.point.compareTo(o1.point);
        });
        int q = bd.nextInt();
        while (q-- > 0) {
            String mhID = bd.next();
            System.out.printf("BANG DIEM MON %s:\n", idToMH.get(mhID));
            a.forEach(e -> {
                if (e.mh.id.equals(mhID)) {
                    System.out.println(e);
                }
            });
        }
        sv.close();
        mh.close();
        bd.close();
    }
}
