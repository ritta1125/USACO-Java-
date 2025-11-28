import java.io.*;
import java.util.*;

public class Main {
  //https://www.acmicpc.net/problem/23878  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(r.readLine());
    char[] cows = r.readLine().toCharArray();
    long sum = 0;

    for(int i = 0; i < N; i++){
      char tmp = cows[i];
      int L = 0;
      int R = 0;

      for(int w = i-1; w >=0; w--){
        if(cows[w] != tmp) L++;
        else break;
      }
      
      for(int e = i+1; e < N; e++){
        if(cows[e] != tmp) R++;
        else break;
      }

      sum += Math.max(0,L-1) + Math.max(0,R-1);  
      sum += (long) L*R;
    }
    
    pw.println(sum);
    //https://blog.naver.com/mycho/220739199883 
    
    pw.close();
  }
}