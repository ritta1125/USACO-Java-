import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/17039 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(r.readLine());
    long[] cows = new long[3];
    
    for(int i = 0; i < 3; i++){
      cows[i] = Long.parseLong(st.nextToken());
    }

    Arrays.sort(cows);

    long a = cows[2] - cows[1];
    long b = cows[1] - cows[0];
    long c = cows[2] - cows[0];
    
    if(a == 2|| b == 2) pw.println("1");
    else if(c == 2) pw.println("0");
    else pw.println("2");

    pw.println(Math.max(a, b) - 1);
        
    pw.close();
  }
}