import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/10751 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    long N = Long.parseLong(r.readLine());
    String text = r.readLine();
    long C = 0;
    long O = 0;
    long ans = 0;

    for(char c: text.toCharArray()){
      if(c == 'C') {
        C++;   
      } 
      if(c == 'O'){ 
        O += C;
      } 
      if(c == 'W') { 
        ans += O;
      }
    }
    
    pw.println(ans);
    pw.close();
  }
}