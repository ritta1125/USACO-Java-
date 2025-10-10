import java.io.*;
import java.util.*;

public class Main {
  static int N, arr[];
  static boolean visit[];
  static PrintWriter pw;
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/10974 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);

    N = Integer.parseInt(r.readLine());
    arr = new int[N];
    visit = new boolean[N];
    DFS(0);
    
    pw.close();
  }

  public static void DFS(int depth){
    if (depth == N) {
      for (int i : arr) {
        pw.print(i + " ");
      }
      pw.println();
      return; 
    }

    for (int i = 0; i < N; i++) {
      if(!visit[i]) {
        visit[i] = true;
        arr[depth] = i + 1;
        DFS(depth+1);
        visit[i] = false;
      }
    }
  }
}
