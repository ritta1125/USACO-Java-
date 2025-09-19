import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/10751 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    String[] correct = new String[3];
    String[] guess = new String[3];
    int green = 0;
    int yellow = 0;
    int[] countC = new int[26];
    int[] countG = new int[26];

    for (int i = 0; i < 3; i++) {
      correct[i] = r.readLine();
    }

    for (int i = 0; i < 3; i++) {
      String tmp = r.readLine();
      guess[i] = tmp;

      for (int j = 0; j < 3; j++) {
        char g = guess[i].charAt(j);
        char c = correct[i].charAt(j);
        if (g == c) {
          green++;
        } else {
          countG[g - 'A']++;
          countC[c - 'A']++;
        }
      }
    }

    for (int i = 0; i < 26; i++) {
      yellow += Math.min(countC[i], countG[i]);
    }

    pw.println(green);
    pw.println(yellow);

    pw.close();
  }
}