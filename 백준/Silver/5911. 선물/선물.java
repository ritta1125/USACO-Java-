import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/5911 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[] P = new int[N];
    int[] S = new int[N];
    

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(r.readLine());
      P[i] = Integer.parseInt(st.nextToken());
      S[i] = Integer.parseInt(st.nextToken());
    }

    long ans = -1; 
    for(int i = 0; i < N; i++){
      long[] tot = new long[N];
      for(int j = 0; j < N; j++){
        if (i==j) {
          tot[j] = (long) (P[j] / 2) + S[j];
        }
        else {
          tot[j] = (long) P[j]  + S[j];
          
        }
      }
      Arrays.sort(tot);

      long price = 0, count = 0; 
      for (long t : tot){
        price += t;
        if (price > B) break;
        count++;
      }
      ans = Math.max(ans,count);
      
    }
    pw.println(ans);
    pw.close();
  }
}