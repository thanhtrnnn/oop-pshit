package LonggVuz;

import java.io.*;
import java.util.*;

class SV {
    public String ma, ten, sdt, email;
    public SV(String ma, String ten, String sdt, String email) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }
}

class DT {
    public String ma, tengv, tendt;
    public static int i = 1;
    public DT(String tengv, String tendt) {
        this.ma = String.format("DT%03d", i++);
        this.tengv = tengv;
        this.tendt = tendt;
    }
}

class HD {
    public String masv, madt, mahd;
    public SV sv;
    public DT dt;
    public HD(String masv, String madt, String mahd) {
        this.masv = masv;
        this.madt = madt;
        this.mahd = mahd;
    }
    public void setSv(SV sv) {
        this.sv = sv;
    }
    public void setDt(DT dt) {
        this.dt = dt;
    }
}

public class baocaott {
    public static void main(String[] args) throws Exception {
        File inp = new File("DATA.in");
        if (inp.exists()) {
            System.setIn(new FileInputStream(inp));
            System.setOut(new PrintStream("DATA.out"));
        }
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<SV> a = new ArrayList<>();
        while (n-- > 0) {
            a.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<DT> b = new ArrayList<>();
        while (m-- > 0) {
            b.add(new DT(sc.nextLine(), sc.nextLine()));
        }
        sc.nextLine();
        int k = sc.nextInt();
        ArrayList<HD> c = new ArrayList<>();
        while (k-- > 0) {
            c.add(new HD(sc.next(), sc.next(), sc.next()));
        }
        for (HD hd : c) {
            for (SV sv : a) {
                if (sv.ma.equals(hd.masv)) {
                    hd.setSv(sv);
                    break;
                }
            }
            for (DT dt : b) {
                if (dt.ma.equals(hd.madt)) {
                    hd.setDt(dt);
                    break;
                }
            }
        }
        Collections.sort(c, (HD o1, HD o2) -> {
            return o1.masv.compareTo(o2.masv);
        });
        for (int i = 1; i <= 8; i++) {
            String s = "HD" + i;
            boolean f = true;
            for (HD hd : c) {
                if (hd.mahd.equals(s)) {
                    if (f) {
                        System.out.println("DANH SACH HOI DONG " + i);
                        f = false;
                    }
                    System.out.printf("%s %s %s %s\n", hd.sv.ma, hd.sv.ten, hd.dt.tendt, hd.dt.tengv);
                }
            }
        }
        sc.close();
    }
    // Biden
}
