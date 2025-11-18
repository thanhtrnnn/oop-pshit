import java.util.*;
import java.io.*;

public class j03004_chuanhoaxauhoten1 {
    static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t -= 1;
            String s = sc.nextLine();
            s = s.toLowerCase();
            s = s.replaceAll("\\s+", " ");
            s = s.trim();       
            String word[] = s.split("\\s");
            for (String i : word) {
                System.out.print(capitalize(i) + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
    
}
