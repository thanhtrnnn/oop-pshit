import java.util.*;
import java.io.*;

public class j03032_daotu {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
    
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String line = sc.nextLine();
            String[] w = line.split(" "); // or \\s+ or [' ']+
            for(int i=0; i<w.length; i++){
                StringBuilder sb = new StringBuilder(w[i]);
                System.out.print(sb.reverse().toString());
                if(i < w.length - 1) System.out.print(" ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
