import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] cows = new int[N];
    int[] sorted_cows = new int[N];

    for(int i = 0; i < N; i++){
      cows[i] = Integer.parseInt(r.readLine());
      sorted_cows[i] = cows[i];
    }
    
    Arrays.sort(sorted_cows);  
    int count = 0; 

    for(int i = 0; i < N; i++){
      if(sorted_cows[i] != cows[i]) count++;
    }
    

    pw.print(Math.max(0,count-1));
    pw.close();
  }
}