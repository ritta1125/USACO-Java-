import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/20650
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(r.readLine());
    int[] num = new int[7]; 
    
    for(int i = 0; i < 7; i++){
      num[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(num);

    int A = num[0];
    int B = num[1];
    int sum = num[6];
    
    pw.print(A + " " + B + " " + (sum - (A + B)));

    pw.close();
  }
}
