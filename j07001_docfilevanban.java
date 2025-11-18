import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class j07001_docfilevanban {
    public static void main(String args[]) throws FileNotFoundException {
        File x = new File("DATA.in");
        Scanner sc = new Scanner(x);
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();    
    }
}
