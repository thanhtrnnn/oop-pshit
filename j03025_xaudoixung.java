import java.util.Scanner;

public class j03025_xaudoixung {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String S = sc.next();
            int cnt = 0;
            for(int i=0; i<S.length()/2; i++){
                if(S.charAt(i) != S.charAt(S.length()-i-1)) cnt++;
            }
            System.out.println((cnt == 1 || (cnt == 0 && S.length() % 2 == 1)) ? "YES" : "NO");
        }
        sc.close();
    }
}
