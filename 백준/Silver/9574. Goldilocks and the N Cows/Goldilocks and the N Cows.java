import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/9574
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int Z = Integer.parseInt(st.nextToken());

    HashMap<Long, Long> map = new HashMap<>();
  
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(r.readLine());

      long A = Long.parseLong(st.nextToken());
      long B = Long.parseLong(st.nextToken());

      
      map.put(A, map.getOrDefault(A,0L) + (Y-X));
      map.put(B+1, map.getOrDefault(B+1,0L) + (Z-Y));
    }

    long T = X*N;
    long max = 0;
    
    ArrayList<Long> arr = new ArrayList<>(map.keySet());
    Collections.sort(arr);


    for(long l: arr){
      T += map.get(l);
      max = Math.max(T, max);
    }

    pw.print(max);
    pw.close();
  }
}
