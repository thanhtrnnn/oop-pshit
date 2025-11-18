import java.util.*;
import java.io.*;

public class j03007_sodep2 {
    static String check(String s){
        int n=s.length();
        if(s.charAt(n-1)!='8') return "NO";
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=s.charAt(i)-'0';
        }
        if(sum%10!=0) return "NO";
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
    
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            System.out.println(check(s));
        }
        sc.close();
    }
}
