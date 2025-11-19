import java.io.*;
import java.util.*;

public class Main {
  //https://www.acmicpc.net/problem/18787 

  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(r.readLine());

    String A = r.readLine();
    String B = r.readLine();
    boolean con = true;
    int count = 0;

    for(int i = 0; i < N; i++){
      if(A.charAt(i) == B.charAt(i)){
        con = false;
      }else{
        if(!con || count == 0){
          count++;
          con = true;
        }
      }
    }

    pw.print(count);
    pw.close();
  }
}