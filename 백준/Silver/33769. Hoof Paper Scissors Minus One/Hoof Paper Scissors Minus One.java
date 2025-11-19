import java.io.*;
import java.util.*;

public class Main {
  // https://www.acmicpc.net/problem/33769

  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N + 1][N + 1];

    for (int i = 0; i < N; i++) {
      String tmp = r.readLine();

      for (int j = 0; j < i + 1; j++) {
        if (tmp.charAt(j) == 'W') {
          arr[i + 1][j + 1] = 1;
        } else if (tmp.charAt(j) == 'L') {
          arr[j + 1][i + 1] = 1;
        }
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(r.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int ww = 0;

      for (int j = 1; j < N + 1; j++) {
        if (arr[j][a] == 1) {
          if (arr[j][b] == 1)
            ww++;
        }
      }

      int sum = 2 * N * ww - (ww * ww);

      pw.println(sum);
    }

    pw.close();
  }
}