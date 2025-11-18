import java.util.*;
import java.io.*;

public class j08028_hinhchunhatdonsac {

    static void min(long[] a, int[] b, int start, int end, int step, int root){
        // find first smaller element index on the left/ right
        Stack<Integer> st = new Stack<>();
        for(int i=start;i!=end;i+=step){
            while(!st.isEmpty() && a[st.lastElement()] >= a[i]) 
                st.pop();
            b[i] = st.isEmpty() ? root : st.lastElement();
            st.push(i);
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);

        int T = 2;
        int m = sc.nextInt(), n = sc.nextInt();
        long[] arr = new long[n];
        long res = 0;
        for(int i=0;i<n;i++) arr[i] = sc.nextLong();
        while(T-->0){
            long[] a = new long[n];
            for(int i=0;i<n;i++){
                if(T==1) a[i]=arr[i];
                else a[i]=m-arr[i];
            }

            int[] l = new int[n];
            int[] r = new int[n];
            min(a, l, 0, n, 1, -1);
            min(a, r, n-1, -1, -1, n);
            long ans = 0;
            for(int i=0;i<n;i++){
                // greedily take height a[i]
                // a[l[i]] < a[i] && a[r[i]] < a[i]
                // so getting a rectangle with max width (r[i]-l[i]-1)
                ans = Math.max(ans, a[i]*(r[i]-l[i]-1));
            }
            res = Math.max(res, ans);
        }
        System.out.println(res);
    }
}
