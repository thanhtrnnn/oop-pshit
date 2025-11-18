import java.io.*;
import java.util.*;

public class j01023_toanlopba {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream(inputFile));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        Scanner sc = new Scanner(System.in);
        int t = 0;
        if (sc.hasNextInt()) {
            t = sc.nextInt();
            sc.nextLine(); // consume end of line
        }

        while (t-- > 0) {
            String line = "";
            // read a non-empty line
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                if (!line.isEmpty()) break;
            }
            if (line.isEmpty()) {
                System.out.println("WRONG PROBLEM!");
                continue;
            }

            String[] exp = line.split("\\s+");
            // Expect format: x opr y = ans
            if (exp.length < 5) {
                System.out.println("WRONG PROBLEM!");
                continue;
            }

            List<String> xs = possibleNum(exp[0]);
            String oprs = possibleOpr(exp[1]);
            List<String> ys = possibleNum(exp[2]);
            List<String> ans = possibleNum(exp[4]);

            boolean found = false;
            String res = "";
            outer:
            for (String xi : xs) {
                for (int oi = 0; oi < oprs.length(); ++oi) {
                    char op = oprs.charAt(oi);
                    for (String yj : ys) {
                        for (String ak : ans) {
                            try {
                                int a = Integer.parseInt(xi);
                                int b = Integer.parseInt(yj);
                                int c = Integer.parseInt(ak);
                                if (evalOp(a, op, b, c)) {
                                    res = xi + " " + op + " " + yj + " = " + ak;
                                    found = true;
                                    break outer;
                                }
                            } catch (NumberFormatException ex) {
                                // ignore malformed candidate
                            }
                        }
                    }
                }
            }

            System.out.println(found ? res : "WRONG PROBLEM!");
        }
        sc.close();
    }

    // Generate possible two-digit numbers from a pattern like "?5", "5?", "??", or concrete "12"
    static List<String> possibleNum(String s) {
        List<String> undefined = new ArrayList<>();
        if (s.length() == 0) return Collections.emptyList();

        if (s.charAt(0) == '?') {
            // leading digit cannot be 0
            for (int i = 1; i <= 9; ++i) {
                undefined.add(Integer.toString(i) + s.charAt(s.length() - 1));
            }
        } else {
            undefined.add(s);
        }

        List<String> nums = new ArrayList<>();
        if (s.charAt(s.length() - 1) == '?') {
            for (String x : undefined) {
                char first = x.charAt(0);
                for (int d = 0; d <= 9; ++d) {
                    nums.add(Character.toString(first) + d);
                }
            }
        } else {
            nums = undefined;
        }

        return nums;
    }

    static String possibleOpr(String s) {
        return s.equals("?") ? "+-*/" : s;
    }

    static boolean evalOp(int a, char op, int b, int c) {
        switch (op) {
            case '+': return a + b == c;
            case '-': return a - b == c;
            case '*': return a * b == c;
            case '/':
                if (b == 0) return false;
                if (a % b != 0) return false;
                return a / b == c;
            default: return false;
        }
    }
}