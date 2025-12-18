import java.io.*;
import java.util.*;

public class bai2_haigiangvien {
    static int i = 1;
    static class GiangVien {
        private String ma, name;
        private int hrs;
        private double heso;
        
        public GiangVien() {}
        
        public GiangVien(int i, String hoten, int gioday, double hsl) {
            ma = String.format("PM000%d", i);
            name = hoten;
            hrs = gioday;
            heso = hsl;
        }
        
        public double getLuongLinh() {
            return hrs * 240 * heso;
        }
        
        public void input(Scanner in) {
            ma = String.format("PM000%d", i);
            name = in.nextLine();
            hrs = in.nextInt();
            heso = in.nextDouble();
            i++;
        }
        
        @Override
        public String toString() {
            return ma + ' ' + name + ' ' + hrs + ' ' + heso + '\n' + getLuongLinh();
        }
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 2; i++) {
//            GiangVien a = new GiangVien(i + 1, sc.nextLine(), sc.nextInt(), sc.nextDouble());
            GiangVien a = new GiangVien();
            a.input(sc);
            if (i == 0) sc.nextLine();
            System.out.println(a);
        }
        sc.close();
    }
}
