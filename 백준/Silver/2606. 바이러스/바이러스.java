import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/2606  

  public static int virus(int[][] arr, int[] visited, int r){
    visited[r] = 1;
    int cnt = 1; 
    for(int i = 1; i < arr.length; i++){
      if(arr[r][i] == 1){
        if(visited[i] == 0){
          cnt += virus(arr, visited, i);
        }
      }
    }
    
    return cnt;
  }
  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    int c = Integer.parseInt(r.readLine());
    int pairs = Integer.parseInt(r.readLine());

    int[][] arr = new int[c+1][c+1];
    int[] visited = new int[c+1];

    for(int i = 0; i < pairs; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    pw.println(virus(arr, visited, 1)-1);
    pw.close();
  }
}