import java.util.*;
import java.io.*;

public class j03024_souuthe {
    static boolean isDigit(char x) {
        if(x>='0' && x<='9') return true;
        return false;
    }
    static String check(String s){
        if(s.charAt(0)=='0') 
            return "INVALID";
        int n=s.length();
        int c=0;
        for(int i=0;i<n;i++){
            if(!isDigit(s.charAt(i))) 
                return "INVALID";
            if((s.charAt(i)-'0')%2==0) c++;
        }
        if (n%2==0 && c>n-c || n%2==1 && c<n-c) 
            return "YES";
        return "NO";
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println(check(sc.next()));
        }
        sc.close();
    }
}
