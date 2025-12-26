import java.io.*;
import java.util.*;

public class Main {

  public static long convert(String s, int base) {
    int a = s.charAt(0) - '0'; 
    int b = s.charAt(1) - '0'; 
    int c = s.charAt(2) - '0'; 
    int res = base; 
    return (long) a * res * res + (long) b * res  + c; 
  }

  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/21235 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int K = Integer.parseInt(r.readLine());

    for(int i = 0; i < K; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      String X = st.nextToken();
      String Y = st.nextToken();

      int bx = 10;
      int by = 10; 

      while (bx <= 15000 && by <= 15000) {

        long cx = convert(X,bx); 
        long cy = convert(Y,by); 

        if (cx < cy) bx++;
        else if (cx > cy) by++;
        else {
          pw.println(bx + " " + by);
          break;
        }
      }
    }
    
    pw.close();
  }
}