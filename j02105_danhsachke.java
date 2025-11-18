import java.io.*;
import java.util.*;

public class j02105_danhsachke {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            System.out.printf("List(%d) = ", i);
            for(int j=1; j<=n; j++){
                int x = sc.nextInt();
                if(x==1) System.out.printf("%d ", j);
            } 
            System.out.println("");
        }
        
        sc.close();
    }
}
