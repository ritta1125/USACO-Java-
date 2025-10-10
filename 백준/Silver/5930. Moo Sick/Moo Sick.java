import java.io.*;
import java.util.*;

public class Main {
  static int[][] ac;
  static int[] cows;
  static long min = Long.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] song = new int[N];
    for(int i = 0; i < N; i++){
      song[i] = Integer.parseInt(r.readLine());
    }
    
    int C = Integer.parseInt(r.readLine());
    int[] rsc = new int[C];
    for(int i = 0; i < C; i++){
      rsc[i] = Integer.parseInt(r.readLine());
    }
    Arrays.sort(rsc);

    ArrayList<Integer> count = new ArrayList<>();

    for(int i = 0; i < N-C+1; i++){
      int[] tmp = new int[C];
      for(int j = 0; j < C; j++){
        tmp[j] = song[j+i];
      }
      Arrays.sort(tmp);
      boolean flag = true;
      for(int j = 0; j < C-1; j++){
        if (tmp[j+1]-tmp[j] != rsc[j+1]-rsc[j]) {
          flag = false;
          break;
          }
      }
      
      if(flag) count.add(i);
    }

    pw.println(count.size());
    for(int i: count){
      pw.println(i+1);
    }
    
    pw.close();
  }

}