import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/31650 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(r.readLine());
    Integer[] c_t = new Integer[N];
    for(int i = 0; i < N; i++){
      c_t[i] = Integer.parseInt(st.nextToken());
    }
    
    st = new StringTokenizer(r.readLine());
    for(int i = 0; i < N; i++){
      c_t[i] -= Integer.parseInt(st.nextToken());
    }

    Arrays.sort(c_t, Collections.reverseOrder());

    for(int i = 0; i < Q; i++){
      st = new StringTokenizer(r.readLine());
      int V = Integer.parseInt(st.nextToken());
      int S = Integer.parseInt(st.nextToken());

      if (c_t[V-1]>S) pw.println("YES");
      else pw.println("NO");
   }   
    
    pw.close();
  }
}
