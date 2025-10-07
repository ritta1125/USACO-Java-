import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int T = Integer.parseInt(r.readLine());

    for(int i = 0; i < T; i++){
      String S = r.readLine();

      if(S.charAt(S.length() - 1) == '0') pw.println("E");
      else pw.println("B");
    }

    pw.close();
  }
}