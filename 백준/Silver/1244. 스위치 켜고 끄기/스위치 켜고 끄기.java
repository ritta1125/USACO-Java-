import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/1244
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out); 

    int N = Integer.parseInt(r.readLine());
    int[] arr = new int[N+1];

    StringTokenizer st = new StringTokenizer(r.readLine());
    
    for(int i = 1; i < N+1; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    int K = Integer.parseInt(r.readLine());
    
    for(int i = 0; i < K; i++){
      st = new StringTokenizer(r.readLine());
      
      int g = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      arr[n] = 1 - arr[n];

      if(g == 1){
        int j = 2*n;
        
        while(j <= N){
          arr[j] = 1 - arr[j];
          j += n;
        }
      }else{
        for(int j = 1; j < n; j++){
          if(n+j > N) break;
          if(arr[n+j] != arr[n-j]) break;

          arr[n+j] = 1 - arr[n+j];
          arr[n-j] = 1 - arr[n-j];
        }
      }      
    }    

    for(int i = 1; i < N+1; i++){
      pw.print(arr[i] + " ");

      if(i%20 == 0) pw.println("");
    }

    pw.close();
  }
}