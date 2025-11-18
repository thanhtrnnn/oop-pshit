import java.util.*;
import java.io.*;
/**
 * SHA256: 
 */
public class j07002_tinhtong {
    public static void main(String args[]){
        File x = new File("DATA.in");
        try{
            long s = 0;
            Scanner sc = new Scanner(x);
            while(sc.hasNext()){
                try{
                    String t = sc.next();
                    s += Integer.parseInt(t);
                }catch(NumberFormatException e){}
            }
            System.out.println(s);
            sc.close();
        } catch(FileNotFoundException e){}
    
    }
}
