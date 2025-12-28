import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/17040 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken()); 
    int M = Integer.parseInt(st.nextToken()); 

    int[][] F = new int[N+1][N+1];

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(r.readLine());

      int f1 = Integer.parseInt(st.nextToken()); 
      int f2 = Integer.parseInt(st.nextToken()); 

      F[f1][f2] = -1;
      F[f2][f1] = -1;
    }

    int[] ans = new int[N+1];
    
    for(int i = 1; i < N+1; i++){
      for (int s = 1; s < 5; s++) {
        boolean check = true;
        for(int j = 1; j < N+1; j++){
          if(F[i][j]<0){
            if(ans[j] == s) {
              check = false;
              break;
            }
          }
        }
        if (check) {
          ans[i] = s;
          break;
        }
      }
    }

    for(int i = 1; i < N+1; i++){
      pw.print(ans[i]);
    }
    
    pw.close();
  }
}