import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/33770 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int T = Integer.parseInt(r.readLine());
    
    for(int i = 0; i < T; i++){
      int N = Integer.parseInt(r.readLine());
      int[] cows = new int[N+1];
      StringTokenizer st = new StringTokenizer(r.readLine());
      int ans = 0;
      int max = 0;
      
      for(int j = 0; j < N; j++){
        int tmp = Integer.parseInt(st.nextToken());
        cows[tmp]++;

        if(cows[tmp] == 2){
          ans += 2;
        }

        max = Math.max(tmp, max);
      }

      if(cows[max] == 1) ans++;
      else ans--;

      pw.println(ans);
    }
    
    pw.close();
  }
}

