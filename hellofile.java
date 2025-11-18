import java.io.*;
import java.util.Scanner;

public class hellofile {
    public static void main(String[] args){
        File file = new File("Hello.txt");
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {

        }
    }
}
