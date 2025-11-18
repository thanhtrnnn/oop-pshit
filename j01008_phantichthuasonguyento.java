import java.io.*;
import java.util.*;

public class j01008_phantichthuasonguyento {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++){
            int n = sc.nextInt();
            System.out.printf("Test %d: ",i);
            int sqrt = (int) Math.sqrt((double)n);
            for(int j=2; j<=sqrt; j++){
                int cnt=0;
                while(n%j==0){
                    n/=j;
                    cnt++;
                }
                if(cnt>0){
                    System.out.printf("%d(%d) ", j, cnt);
                }
            }
            if(n>1) System.out.printf("%d(1)", n);
            System.out.println("");
        }
        sc.close();
    }
}
