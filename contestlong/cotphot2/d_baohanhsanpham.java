import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class d_baohanhsanpham {
    static HashMap<String, Product> mp = new HashMap<>();
    static class Product {
        private String id, name;
        private int price, warr;

        public Product(String id, String name, int price, int warr) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.warr = warr;
        }

    }

    static class Customer {
        private String id, name, addr, masp, buy;
        private Product p;
        private int sl;
        private long total;

        public Customer(int i, String name, String addr, String masp, int sl, String buy) {
            this.id = String.format("KH%03d", i);
            this.name = cleanName(name);
            this.addr = addr;
            this.p = mp.get(masp);
            this.buy = cleanDate(buy);
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate x = LocalDate.parse(this.buy, f).plusMonths(p.warr);
            this.buy = x.format(f);
            this.sl = sl;
            this.masp = masp;
            this.total = (long) p.price * sl;
        }

        @Override
        public String toString() {
            return String.format("%s %s %s %s %d %s", id, name, addr, masp, total, buy);
        }
        
    }
    public static void main(String[] args) throws IOException {
        // File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        // }
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = sc.nextInt();
        ArrayList<Product> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String ma = sc.nextLine();
            Product x = new Product(ma, sc.nextLine(), sc.nextInt(), sc.nextInt());
            mp.put(ma, x);
            a.add(x);
        }

        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Customer> kh = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            kh.add(new Customer(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }

        kh.sort((o1, o2) -> { 
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d1 = LocalDate.parse(o1.buy, f);
            LocalDate d2 = LocalDate.parse(o2.buy, f);
            return (d1.equals(d2)) 
                ? o1.id.compareTo(o2.id)  
                : d1.compareTo(d2);
        });
        kh.forEach(System.out::println);
        sc.close();
    }

    static String cleanDate(String date) {
        StringBuilder res = new StringBuilder(date);
        if (res.charAt(1) == '/')
            res.insert(0, '0');
        if (res.charAt(4) == '/')
            res.insert(3, '0');
        return res.toString();
    }

    static String cleanName(String name) {
        String res = new String();
        String[] w = name.trim().toLowerCase().split("\\s+");
        for (int i = 0; i < w.length; i++) {
            res += w[i].substring(0, 1).toUpperCase() + w[i].substring(1) + " ";
        }
        return res.trim();
    }
}