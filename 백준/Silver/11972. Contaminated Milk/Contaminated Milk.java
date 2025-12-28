import java.io.*;
import java.util.*;


public class Main {
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/18988
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken()); //<=50
    int M = Integer.parseInt(st.nextToken()); //<=50
    int D = Integer.parseInt(st.nextToken()); //<=1000
    int S = Integer.parseInt(st.nextToken()); //<=N

    int[][] sick = new int[S][2]; //[p,t]    
    int[][] drinks = new int[D][3]; //[p,t,m]

    
    for(int i = 0; i < D; i++){
      st = new StringTokenizer(r.readLine());

      drinks[i][0] = Integer.parseInt(st.nextToken()); //p
      drinks[i][2] = Integer.parseInt(st.nextToken()); //m
      drinks[i][1] = Integer.parseInt(st.nextToken()); //t
    }
    
    for(int i = 0; i < S; i++){
      st = new StringTokenizer(r.readLine());

      sick[i][0] = Integer.parseInt(st.nextToken()); //p
      sick[i][1] = Integer.parseInt(st.nextToken()); //t
    }

   

    //p -> tD < tS -> m 
    //m -> p 

    int ans = 0; 
    
    for (int m = 1; m < M+1; m++) {
      boolean check = true; 
      for(int s = 0; s < S; s++){
        int p = sick[s][0];
        int tS = sick[s][1];

        boolean before = false; 
        for(int d = 0; d < D; d++){
          if (drinks[d][0] == p && drinks[d][2] == m && drinks[d][1] < tS) {
            before = true;
            break; 
          }
        }

        if (!before) {
          check = false;
          break;
        }
      }
  
      if (!check) continue;
  
      HashSet<Integer> pS = new HashSet<>();
  
  
      for(int d = 0; d < D; d++){
        if (drinks[d][2] == m) {
          pS.add(drinks[d][0]);
        }
      }

      ans = Math.max(ans,pS.size());
      
    }

    pw.println(ans);
    pw.close();
  }
}