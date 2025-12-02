//It's Mooin' Time II (https://usaco.org/index.php?page=viewproblem2&cpid=1468 )
// https://www.acmicpc.net/problem/33508 

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());

    StringTokenizer st = new StringTokenizer(r.readLine());
    int[] order = new int[N];
    int[] L = new int[N+1];
    int[] R = new int[N+1];

    long ans = 0;

    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      order[i] = tmp;
      R[tmp]++;
    }

    int num = 0;

    for(int i: order){
      boolean add = L[i]==0;
      num += add? 1:0;

      if(R[i] == 2){
        ans += num-1;
      }

      L[i]++;
      R[i]--;
    }

    pw.println(ans);
    pw.close();
  }
}