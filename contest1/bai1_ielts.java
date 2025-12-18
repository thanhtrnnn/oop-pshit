import java.io.*;
import java.util.*;

public class bai1_ielts {
    static double calc(int n) {
        if (n >= 39) return 9.0;
        else if (n >= 37) return 8.5;
        else if (n >= 35) return 8.0;
        else if (n >= 33) return 7.5;
        else if (n >= 30) return 7.0;
        else if (n >= 27) return 6.5;
        else if (n >= 23) return 6.0;
        else if (n >= 20) return 5.5;
        else if (n >= 16) return 5.0;
        else if (n >= 13) return 4.5;
        else if (n >= 10) return 4.0;
        else if (n >= 7) return 3.5;
        else if (n >= 5) return 3.0;
        else if (n >= 3) return 2.5;
        else return 1.0;
    }
    
    static double rou(double x) {
        double ext = x - (int)x;
        if (ext >= 0.75) return (int)x + 1.0;
        if (ext >= 0.25) return (int)x + 0.5;
        return (float)(int)x;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("D:\\Document\\NetBeansProjects\\B23DCAT280\\src\\main\\java\\com\\mycompany\\B23DCAT280\\output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            double read = calc(sc.nextInt()), lis = calc(sc.nextInt());
            double speak = sc.nextDouble(), wri = sc.nextDouble();
            
            double tbc = (read + lis + speak + wri) / 4;
            
//            if (tbc - (int)tbc == 0.25) tbc += 0.25;
//            else if (tbc + 0.25 == (int)(tbc + 0.25)) tbc += 0.25;
//            else if (tbc - (int)tbc == 0.5) tbc = tbc;
//            else tbc = Math.round(tbc);
            
//            System.out.printf("%.1f\n", tbc);
            System.out.println(rou(tbc));
        }
        sc.close();
    }
}
