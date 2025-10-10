import java.io.*;
import java.util.*;

public class Main {
  static int[][] ac;
  static int[] cows;
  static long min = Long.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    cows = new int[101];
    ac = new int[M][4];

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(r.readLine());
      int s = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      for(int j = s; j<= t; j++){
        cows[j] += c;
      }
    }

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(r.readLine());
      for(int j = 0; j < 4; j++){
        ac[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Arrays.sort(ac,Comparator.comparingInt(c -> c[3]));

    int[] arr = new int[M];
    for(int i =0; i < M; i++) arr[i] = i;
    boolean[] visited = new boolean[M];

    for(int i = 1; i <= M; i++){
      combination(arr,visited,0,0,i); 
    }


    pw.print(min);
    pw.close();
  }

  public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
    if (depth == r) {
      int[] pick = new int[r];
      int idx = 0; 
      for (int i =0; i < arr.length; i++){
        if (visited[i]) {
          pick[idx++] = arr[i];
        }
      }
      long tot = check(pick);
      if (tot > 0 && tot < min ) min = tot;
      return; 
    }

    for(int i = start; i < arr.length; i++){
      if(!visited[i]){
        visited[i] = true;
        combination(arr, visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }


  public static long check(int[] candidates){
    int[] g = new int[101]; 
    long total = 0; 

    for(int idx : candidates){
      int a = ac[idx][0];
      int b = ac[idx][1]; 
      int p = ac[idx][2];
      int m = ac[idx][3]; 

      total += m;
      for (int i =a; i <=b; i++) g[i] += p; 
    }

    for (int i =1; i<=100; i++) {
      if (g[i] < cows[i]) return 0;
    }

    return total;
  }

}