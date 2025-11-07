import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/26215 
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    Integer[] snow = new Integer[N];
    StringTokenizer st = new StringTokenizer(r.readLine());
    
    for(int i = 0; i < N; i++){
      snow[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(snow, Collections.reverseOrder());

    int count = 0;

    if (N > 1) {
      while(snow[0] > 0){
        count++;

        snow[0] -= 1;
        snow[1] -= snow[1] > 0? 1:0;

        Arrays.sort(snow, Collections.reverseOrder());
      }
    }
    
    count += snow[0];
    count = (count > 1440)? -1: count;

    pw.println(count);
    pw.close(); 
  }
}
