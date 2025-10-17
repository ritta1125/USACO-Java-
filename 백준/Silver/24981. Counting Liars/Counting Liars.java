import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    String[] type = new String[N]; 
    int[] pos = new int[N]; 
    
    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      type[i] = st.nextToken();
      pos[i] = Integer.parseInt(st.nextToken());
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++){
      int tmpP = pos[i]; //진실을 말하는 소의 위치 
      int count = 0;
      
      for (int j = 0; j < N; j++){
        int comP = pos[j];
        String tmp = type[j];
        
        if(tmpP > comP && tmp.equals("L") || tmpP < comP && tmp.equals("G"))
          count++;          
      }

      min = Math.min(min, count);
    }

    pw.print(min);    
    pw.close();
  }
}