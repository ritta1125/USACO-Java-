import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/9881
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] hills = new int[N];

    for(int i = 0; i < N; i++){
      hills[i] = Integer.parseInt(r.readLine());
    }

    Arrays.sort(hills);

    int minCost = Integer.MAX_VALUE;

    for(int max = 100; max > 16; max--){
      int cost = 0;
      int min = max - 17; 
      
      for (int i = 0 ; i < N; i++){
        if (hills[i] > max) cost += (int)Math.pow(hills[i] - max, 2);
        else if (hills[i] < min) cost += (int)Math.pow(min - hills[i], 2);
      }

      minCost = cost < minCost? cost: minCost;
    }
    
    pw.println(minCost);
    pw.close();

  }

}