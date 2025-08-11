import java.io.*;
import java.util.*;
import java.lang.Math.*;

class Main {
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try { 
                    st = new StringTokenizer(br.readLine());				               
                } catch (IOException e) {}
			return st.nextToken();
		}

        String readline() {
            String s = "";
            try {
                s = br.readLine().trim();
            } catch (IOException e) {}
            return s;
        }
		
		int nint() {
			return Integer.parseInt(next());
		}
		long lint() {
			return Long.parseLong(next());
		}

        double dint() {
            return Double.parseDouble(next());
        }

        int[] aint() {
            String s = readline();
            int[] arr = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            return arr;
        }
	}
    public static void main(String[] args) throws IOException {
        File inputFile = new File("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt");
        if (inputFile.exists()) {
            System.setIn(new FileInputStream("E:/OneDrive - ptit.edu.vn/pro/dsa/input.txt"));
            System.setOut(new PrintStream("E:/OneDrive - ptit.edu.vn/pro/dsa/output.txt"));
        }
        
        FastScanner sc = new FastScanner();
        // basics
        double a = 1.0;
        int b = (int)a;
        int t = sc.nint();
        int n = 0, m;
        for (int i = 0; i < t; i++) {
            n = sc.nint();
            m = sc.nint();
            System.out.println("Test case " + (i + 1) + ": n = " + n + ", m = " + m);
        
            // 1d and 2d array
            int[] arr = new int[n]; // all 0s
            // int[][] arr2D = new int[100][100]; // all 0s
            arr = sc.aint(); // read array from input
            Arrays.sort(arr); // sorts in ascending order
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        
            // build a counter
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            // for (int key : map.keySet()) {
            //     System.out.println("Key: " + key + ", Value: " + map.get(key));
            // }
        }
        
        System.out.println(Integer.MIN_VALUE + Math.max(0, 1));
        System.out.println("Hello, World!");
        
    }
}