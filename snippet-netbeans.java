<#if package?? && package != "">
package ${package};
</#if>

import java.io.*;
import java.util.*;

public class ${name} {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream(outputFile));
        }
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        ArrayList<> a = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            sc.nextLine();
            a.add(new );

        }
        a.sort((o1, o2) -> {});
        a.forEach(System.out::println);
        sc.close();
    }
}