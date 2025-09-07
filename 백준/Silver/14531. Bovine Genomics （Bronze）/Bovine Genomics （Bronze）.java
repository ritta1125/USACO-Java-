import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/14531 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(r.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String[] spot = new String[N];
    String[] norm = new String[N];

    for(int i = 0; i < N; i++){
      spot[i] = r.readLine();
    }

    for(int i = 0; i < N; i++){
      norm[i] = r.readLine();
    }

    int count = 0;
    
    for(int i = 0; i < M; i++){
      boolean isTrait = true;
      
      for(int j = 0; j < N; j++){
        for(int k = 0; k < N; k++){
          if(spot[k].charAt(i) == norm[j].charAt(i)) isTrait = false;
        }
      }

      if(isTrait) count++;
    }

    pw.print(count);
    pw.close();
  }
}