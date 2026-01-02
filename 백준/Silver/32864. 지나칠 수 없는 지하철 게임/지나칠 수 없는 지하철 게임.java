import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/32864
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    boolean isFair = false; 
    int count = 0;
    String ans = "mnx";
    
    
    StringTokenizer st = new StringTokenizer(r.readLine());

    for(int i = 0; i < N; i++){
      int A = Integer.parseInt(st.nextToken());

      if(i == 1 && A == 1){
        isFair = true;
      }

      if(isFair){
        if(A == 1){
          count++;
        }else{
          if(count%2!=0 || count == 1)
            ans = "alsdkffhgk";
          isFair = false;
        }
      }
    }

    pw.print(ans);
    pw.close();
  }
}
