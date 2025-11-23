import java.io.*;
import java.util.*;

public class Main {
  //https://www.acmicpc.net/problem/1421  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());

    int[] wood = new int[N];
    int max = 0;

    for(int i = 0; i < N; i++){
      wood[i] = Integer.parseInt(r.readLine());
      max = Math.max(max, wood[i]);
    }

    long maxProfit = 0;

    for(int i = 1; i <= max; i++){
      long profit = 0;
      for(int j: wood){
        int K = j/i;
        int R = j%i;
        int cost;
        if (R > 0) cost = K * C;
        else cost = (K-1) * C;
        long p = (long) K * W * i - cost;
        if (p >0) profit += p;
      }
      maxProfit = Math.max(profit,maxProfit);
    }
    
    pw.print(maxProfit);
    pw.close();
  }
}