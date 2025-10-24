import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    // '0' -> '1'
    // (char) ('0' + 1)
    // (char) ('0' + i)

    long X = Long.parseLong(st.nextToken());
    long Y = Long.parseLong(st.nextToken());
    int count = 0;

    for (int i = 3; i < 18; i++) {
      char[] interesting = new char[i];

      for (int a = 0; a < 10; a++) {
        for (int j = 0; j < i; j++) {
          interesting[j] = (char) ('0' + a); // a -> 1 / ['1','1','1']
        }

        for (int b = 0; b < 10; b++) {
          if (a == b)
            continue;
          for (int x = 0; x < i; x++) {
            interesting[x] = (char) ('0' + b); // a -> 1 / ['1','2','1']

            if (interesting[0] != '0') {
              long num = Long.parseLong(new String(interesting));

              if (num >= X && num <= Y)
                count++;
            }

            interesting[x] = (char) ('0' + a);
          }
        }
      }
    }

    pw.println(count);
    pw.close();
  }
}