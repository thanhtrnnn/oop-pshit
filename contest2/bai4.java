package B23DCAT280;

import java.util.*;
import java.io.*;

public class bai4 {

    static class MatHang {

        String code, name, loai;
        float buy, sell, profit;

        public MatHang(int i, String name, String loai, float x, float y) {
            this.code = String.format("MH%02d", i);
            this.name = name;
            this.loai = loai;
            this.buy = x;
            this.sell = y;
            this.profit = y - x;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %.2f", code, name, loai, profit);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        ArrayList<MatHang> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            a.add(new MatHang(i + 1, sc.nextLine(), sc.nextLine(), sc.nextFloat(), sc.nextFloat()));
        }
        a.sort((x, y) -> (int) (y.profit - x.profit));
        a.forEach(System.out::println);
    }
}
