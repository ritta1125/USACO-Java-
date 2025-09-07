import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/11999
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(r.readLine());
    int X = Integer.parseInt(st.nextToken());
    int Y = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int max = 0;
    
    for(int x = 0; x < M/X + 1; x++){
      for(int y = 0; y < M/Y + 1; y++){
        int sum = x * X + y * Y;
        
        if(sum <= M){
          max = sum > max? sum : max;
        }
      }
    }
    
    pw.print(max);
    pw.close();
  }
}