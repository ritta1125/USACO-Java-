import java.io.*;
import java.util.*;

public class Main {
  public static int[] F;
  public static int N;
  public static int[] visited;
  

  public static int isLoopy(int curr){
    if (curr == 0)  return 2; 
    if (visited[curr] == 2 || visited[curr] == 3)  return visited[curr];
    if (visited[curr] == 1) return 3;

    visited[curr] = 1;

    int next = F[curr];
    int res = isLoopy(next);

    visited[curr] = (res == 3) ? 3 : 2;

    return (res == 3) ? 3 : 2;
    
  }
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/5848
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine()); 
    F = new int[N+1];
    visited = new int[N+1];
    int ans = 0;

    for(int i = 1; i < N+1; i++){
      F[i] = Integer.parseInt(r.readLine()); 
    }

    for(int i = 1; i < N+1; i++){
      if(isLoopy(i) == 2){
        ans++;
      }
    }

    pw.println(ans);
    pw.close();
    
  }

}