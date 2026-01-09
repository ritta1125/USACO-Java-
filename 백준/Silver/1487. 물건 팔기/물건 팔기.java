import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/1487
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out); 

    int N = Integer.parseInt(r.readLine());
    int[][] arr = new int[N][2];

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());

      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken()); 
    }  
    
    Arrays.sort(arr,Comparator.comparingInt(a -> a[0]));

    int ans = 0;
    int c = 0;
    
    for(int i = 0; i < N; i++){
      int tmp = 0;
      
      for(int j = i; j < N; j++){
        int t = arr[i][0] - arr[j][1];
        
        if(t > 0) tmp += t;
      }

      if(tmp > ans){
        c = arr[i][0];
        ans = tmp;
      }
    }  

    pw.print(c);
    pw.close();
  }
}