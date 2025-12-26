import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/27022
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int D = Integer.parseInt(r.readLine());
    HashSet<Integer> NS = new HashSet<>();
    HashSet<Integer> EW = new HashSet<>();
    int x = 0;
    int y = 0;

    for(int i = 0; i < D; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      String d = st.nextToken();
      int num = Integer.parseInt(st.nextToken());

      if(d.equals("N")) {
        y+=num;
        NS.add(x);
      }
      else if(d.equals("S")) {
        y-=num;
        NS.add(x);
      }
      else if(d.equals("W")) {
        x-=num;
        EW.add(y);
      }
      else if(d.equals("E")) {
        x+=num;
        EW.add(y);
      }

    }

    pw.println(NS.size() + EW.size());
    pw.close();
  }
}