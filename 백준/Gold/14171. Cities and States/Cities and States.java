import java.io.*;
import java.util.*;

public class Main {
  //https://www.acmicpc.net/problem/14171  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(r.readLine());
    HashMap<String, Integer> map = new HashMap<>();
    String[][] arr = new String[N][2];
    long count = 0;

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      arr[i][0]= st.nextToken().substring(0, 2);
      arr[i][1]= st.nextToken().substring(0, 2);
    }

    for(int i = 0; i < N; i++){
      String n = arr[i][0]; 
      String c = arr[i][1];  //"FIML"
      count += !n.equals(c)? map.getOrDefault(c+n,0): 0;
      map.put(n+c, map.getOrDefault(n+c,0)+1);
    }

    pw.println(count);
    pw.close();
  }
}