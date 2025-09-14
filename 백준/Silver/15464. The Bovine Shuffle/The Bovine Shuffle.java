import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/15464

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] shuffle = new int[N + 1];
    int[] cows = new int[N + 1];

    StringTokenizer st = new StringTokenizer(r.readLine());
    for (int i = 1; i < N+1; i++) {
      int s = Integer.parseInt(st.nextToken());
      shuffle[s] = i;
    }

    st = new StringTokenizer(r.readLine());
    for (int i = 1; i < N + 1; i++) {
      cows[i] = Integer.parseInt(st.nextToken());
    }

    int[] reverse = reverseShuffle(shuffle, cows);


    for (int i = 0; i < 2; i++) {
      reverse = reverseShuffle(shuffle, reverse);
    }

    for (int j = 1; j < N + 1; j++) {
      pw.println(reverse[j]);
    }

    pw.close();
  }

  public static int[] reverseShuffle(int[] shuffle, int[] cows) {

    int[] result = new int[shuffle.length];

    for (int i = 1; i < shuffle.length; i++) {
      result[shuffle[i]] = cows[i];
    }

    return result;
  }
}