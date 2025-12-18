package B23DCAT280;

import java.io.*;
import java.util.*;

public class bai3 {

    static class MonHoc {

        String id, name;
        int tin;
        ArrayList<Lich> lich;

        public MonHoc(String id, String name, int tin) {
            lich = new ArrayList<>();
            this.id = id;
            this.name = name;
            this.tin = tin;
        }

        @Override
        public String toString() {
            String res = "";
            for (int i = 0; i < lich.size(); i++) {
                res += lich.get(i).toString() + '\n';
            }
            return res;
        }

        public void sort() {
            lich.sort((x, y) -> {
                if (x.thu == y.thu) {
                    if (x.kip == y.kip) {
                        return x.tenGV.compareTo(y.tenGV);
                    }
                    return x.kip - y.kip;
                }
                return x.thu - y.thu;
            });
        }

    }

    static class Lich {

        String id, ma, tenGV, phong;
        int thu, kip;

        public Lich(int i, String ma, String tenGV, String phong, int thu, int kip) {
            this.id = String.format("HP%03d", i);
            this.ma = ma;
            this.tenGV = tenGV;
            this.phong = phong;
            this.thu = thu;
            this.kip = kip;
        }

        @Override
        public String toString() {
            return id + " " + thu + " " + kip + " " + tenGV + " " + phong;
        }
        
    }

    public static void main(String[] args) throws IOException {
        Scanner mh = new Scanner(new File("MONHOC.in"));
        Scanner lich = new Scanner(new File("LICHGD.in"));
        HashMap<String, MonHoc> idToMH = new HashMap<>();

        int t = mh.nextInt();
        for (int i = 0; i < t; i++) {
            mh.nextLine();
            MonHoc x = new MonHoc(mh.nextLine(), mh.nextLine(), mh.nextInt());
            idToMH.put(x.id, x);
        }

        t = lich.nextInt();
        lich.nextLine();
        for (int i = 0; i < t; i++) {
            String code = lich.nextLine();
            int thu = lich.nextInt();
            int kip = lich.nextInt();
            lich.nextLine();
            String ten = lich.nextLine();
            String phong = lich.nextLine();
            Lich x = new Lich(i + 1, code, ten, phong, thu, kip);
            idToMH.get(code).lich.add(x);
        }

        String codeMH = lich.nextLine();
        MonHoc x = idToMH.get(codeMH);
        x.sort();
        System.out.printf("LICH GIANG DAY MON %s:\n", x.name);
        System.out.println(x);

        mh.close();
        lich.close();
    }
}
