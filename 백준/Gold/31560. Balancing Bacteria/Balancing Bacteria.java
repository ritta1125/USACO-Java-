import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/31560 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    long[] grass = new long[N];
    StringTokenizer st = new StringTokenizer(r.readLine());

    for(int i = 0; i < N; i++){
      grass[i] = Long.parseLong(st.nextToken());  
    }

    long ans = 0;
    int count = 0;
    long before = 0;
    
    for(int i = 0; i < N; i++){
      before += count;
      long tmp = grass[i]+before;
      
      ans += Math.abs(tmp);
      long change = -tmp;
      
      count += change;
      before += change;      
    }

    pw.println(ans);
        
    pw.close();
  }
}

