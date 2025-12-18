package B23DCAT280;

import java.io.*;
import java.util.*;

public class bai2 {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream(outputFile));
        }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        System.out.println(t);
        sc.close();
    }
}