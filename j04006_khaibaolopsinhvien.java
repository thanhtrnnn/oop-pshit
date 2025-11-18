import java.util.*;
import java.io.*;

public class j04006_khaibaolopsinhvien {
    static class SinhVien {
        private String ma, ten, lop, ngaysinh;
        private float gpa;
        private static String convert(String d){
            String[] arr = d.split("/");
            for(int i=0; i<arr.length; i++){
                if(arr[i].length()<2) arr[i] = "0" + arr[i];
            }
            return arr[0] + "/" + arr[1] + "/" + arr[2];
        }

        public SinhVien(String ten, String lop, String ngaysinh, float gpa) {
            this.ma = "B20DCCN001";
            this.ngaysinh = convert(ngaysinh);
            this.ten = ten;
            this.lop = lop;
            this.gpa = gpa;
        }
        @Override
        public String toString() {
            return ma + " " + ten + " " + lop + " " + ngaysinh + " " + String.format("%.2f", gpa);
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        SinhVien x = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()));
        System.out.println(x);
        sc.close();
    }
}
