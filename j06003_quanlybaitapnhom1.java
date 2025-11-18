import java.io.*;
import java.util.*;

public class j06003_quanlybaitapnhom1 {
    static class BT {
        
    }

    static class SV {
        private String id, name, tel;
        private int group;

        public SV(String msv, String ten, String sdt, int nhom) {
            id = msv;
            name = ten;
            tel = sdt;
            group = nhom;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + tel;
        }

    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        // Sinh vien
        int n = sc.nextInt(), m = sc.nextInt();
        List<SV> a = new ArrayList<SV>();
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            a.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt()));
        }
        
        // Bai tap lon
        sc.nextLine();
        String btl[] = new String[m];
        for (int i = 0; i < m; i++)
            btl[i] = sc.nextLine();

        int q = sc.nextInt();
        while (q-- > 0) {
            int currGroup = sc.nextInt();
            System.out.printf("DANH SACH NHOM %d:\n", currGroup);
            a.forEach(x -> {
                if (x.group == currGroup)
                    System.out.println(x);
            });
            System.out.printf("Bai tap dang ky: %s\n", btl[currGroup - 1]);
        }

        sc.close();
    }
}