import java.io.*;
import java.util.*;

public class j06001_tinhtoanhoadonbanquanao {
    static class product {
        String code, name;
        Long price1, price2;

        public product(String code, String name, Long price1, Long price2) {
            this.code = code;
            this.name = name;
            this.price1 = price1;
            this.price2 = price2;
        }

        private Long getPrice(String c) {
            return (c.charAt(2) == '1') ? price1 : price2;
        }

    }

    static class bill {
        String code, productName;
        int quantity;
        Long discount, total;

        public bill(int i, String code, String name, int quantity, Long price) {
            this.code = code + String.format("-%03d", i);
            this.productName = name;
            this.quantity = quantity;
            this.total = price * quantity;
            this.discount = calculateDiscount();
            this.total -= discount;
        }

        private Long calculateDiscount() {
            return (this.quantity >= 150) ? Math.round(0.5 * this.total)
                    : (this.quantity >= 100) ? Math.round(0.3 * this.total)
                            : (this.quantity >= 50) ? Math.round(0.15 * this.total) : 0;
        }

        @Override
        public String toString() {
            return code + " " + productName + " " + discount + " " + total;
        }
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<product> a = new ArrayList<>();
        ArrayList<bill> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            a.add(new product(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong()));
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            sc.nextLine();
            String code = sc.next();
            product x = a.stream().filter(p -> code.startsWith(p.code)).findFirst().get();
            b.add(new bill(i + 1, code, x.name, sc.nextInt(), x.getPrice(code)));
        }

        b.forEach(System.out::println);
        sc.close();
    }
}