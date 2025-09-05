import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/11976 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int[] promoted = new int[3];
 
    for(int i = 0; i < 4; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      int bef = Integer.parseInt(st.nextToken());
      int aft = Integer.parseInt(st.nextToken());

      for(int j = 0; j < i; j++){
        promoted[j] += aft - bef;
      }
    }

    for(int i = 0; i < 3; i++){
      pw.println(promoted[i]);
    }
    
    pw.close();
  
  }

}