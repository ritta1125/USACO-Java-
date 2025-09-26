import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/16769

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int[] max = new int[3];
    int[] curr = new int[3];

    for(int i = 0; i < 3; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      max[i] = Integer.parseInt(st.nextToken());
      curr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < 100; i++){
      int tmp1 = i % 3, tmp2 = (i+1) % 3;
      int a = curr[tmp1];
      int b = curr[tmp2]; 

      curr[tmp2] = Math.min(max[tmp2], a+b); 
      curr[tmp1] = a + b - curr[tmp2];  
    }

    for(int i = 0; i < 3; i++){
      pw.println(curr[i]);
    }
    
    pw.close();
  }
}
