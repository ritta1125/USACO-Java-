import java.io.*;
import java.util.*;

public class Main {
  static int N, M, arr[];
  static PrintWriter pw;

  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/15650
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[M];
    DFS(0, 0);

    pw.close();
  }

  public static void DFS(int depth, int start) {
    if (depth == M) {
      for (int i : arr) {
        pw.print(i + " ");
      }
      pw.println();
      return;
    }

    for (int i = start; i < N; i++) {
      arr[depth] = i + 1;
      DFS(depth + 1, i + 1);
    }
  }
}