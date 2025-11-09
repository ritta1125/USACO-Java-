import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/5921 
  static boolean found = false;
  static PrintWriter pw = new PrintWriter(System.out);

  public static boolean check(long c, long p) {
    
    while(c/10 > 0 || p/10 > 0){
      if(c%10 < p%10){
        return false;
      }
      
      p/=10;
      c/=10;    
    }

    return true;
  }

  public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
    if (found) return; 
    
    if(depth == r) {
      //원하는 개수의 조합을 골랐다! 
      long pre = 0; 
      long curr; 
      boolean ok = true; 
      for (int i = 0; i < arr.length; i++) {
        if (visited[i]) {
          curr = pre + arr[i];
          if (!check(curr,pre)){ // carry 가 있냐 없냐 
            ok = false;
            break;
          }
          pre = curr; 
        }
      }

      if (ok) {
        pw.println(r);
        pw.close();
        found = true; 
      }

      return;
     
    }
    
    for(int i = start; i < arr.length; i++){
      if (found) return; 
      if(!visited[i]){
        visited[i] = true;
        combination(arr, visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }

  

  
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
   

    int N = Integer.parseInt(r.readLine());
    int[] cows = new int[N];
    
    for(int i = 0; i < N; i++){
      cows[i] = Integer.parseInt(r.readLine());
    }
    
    for (int i = N; i >= 0; i--){
      boolean[] visited = new boolean[N]; 
      combination(cows, visited, 0, 0, i);
      if (found) return;//break; 
    }
    
  }
}



