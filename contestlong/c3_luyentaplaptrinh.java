import java.io.*;
import java.util.*;

public class c3_luyentaplaptrinh {
    static class student {
        private String name;
        private int bai, nop;
        public student(String name, int bai, int nop) {
            this.name = name;
            this.bai = bai;
            this.nop = nop;
        }
        @Override
        public String toString() {
            return this.name + ' ' + this.bai + ' ' + this.nop;
        }
    }
    public static void main(String[] args) throws IOException {
        // File inputFile = new File("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\input.txt");
        // if (inputFile.exists()) {
        //     System.setIn(new FileInputStream(inputFile));
        //     System.setOut(new PrintStream("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\output.txt"));
        // }
       File inputFile = new File("LUYENTAP.in");
       if (inputFile.exists()) {
           System.setIn(new FileInputStream(inputFile));
           System.setOut(new PrintStream("LUYENTAP.out"));
       }
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        ArrayList<student> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            a.add(new student(sc.nextLine(), sc.nextInt(), sc.nextInt()));
        }
        a.sort((o1, o2) -> {
            if (o1.bai != o2.bai) return -o1.bai + o2.bai;
            else if (o1.nop != o2.bai) return o1.nop - o2.nop;
            else return o2.name.compareTo(o1.name);
        });
        a.forEach(System.out::println);
        sc.close();
    }
}
