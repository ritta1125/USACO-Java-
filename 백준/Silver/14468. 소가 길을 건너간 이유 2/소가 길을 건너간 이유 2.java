import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/14468
    //ABCBDEEFFGGHIIJJHKDKLCLMMNNOOPPQQRRSSTTUUVVWAWXXYYZZ
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    String cows = r.readLine();
    int[][] path = new int[26][2];

    for (int i = 0; i < 26; i++) {
        path[i][0] = -1;
        path[i][1] = -1;
    }
    
    int count = 0;
    
    for(int i = 0; i < 52; i++){
      int idx = cows.charAt(i) - 'A'; //'B' - 'A' 
      if(path[idx][0] == -1) path[idx][0] = i;
      else path[idx][1] = i;      
    }
    

    for(int i = 0; i < 26; i++){
      for(int j = 0; j < 26; j++){
        int startI = path[i][0];
        int endI = path[i][1];
        int startJ = path[j][0];
        int endJ = path[j][1];

        if(startI < startJ && endI < endJ && endI > startJ) count++;        
      }
    } 
    

    pw.print(count);
    
    pw.close();
  
  }

}
