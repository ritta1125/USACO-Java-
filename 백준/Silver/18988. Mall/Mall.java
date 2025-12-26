import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/18988
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] shops = new int[m+1];

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(r.readLine());

      int k = Integer.parseInt(st.nextToken());
      for(int j = 0; j < k; j++){
        int tmp = Integer.parseInt(st.nextToken());
        
        shops[tmp] = i+1;
      }
    }

    boolean yes = true;

    for(int i = 1; i < m+1; i++){
      if(shops[i] == 0){
        pw.println("NO");
        yes = false;
        break;
      }
    }

    if(yes) {
      pw.println("YES");
      
      for(int i = 1; i < n+1; i++){
        pw.print(i + " ");
      }
      pw.println("");
  
      for(int i = 1; i < m+1; i++){
        pw.print(shops[i] + " ");
      }
    }
    

    pw.close();
  }
}