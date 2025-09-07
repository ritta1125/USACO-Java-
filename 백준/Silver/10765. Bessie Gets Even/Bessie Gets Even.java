import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    HashMap<String, Integer> map = new HashMap<>();
    map.put("B", 0);
    map.put("E", 1);
    map.put("S", 2);
    map.put("I", 3);
    map.put("G", 4);
    map.put("O", 5);
    map.put("M", 6);

    int[][] cnt = new int[7][2];


    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(r.readLine());
      int idx = map.get(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      int p = Math.abs(num) % 2;
      cnt[idx][p]++;    
    }

    long ans = 0; 

    for(int b = 0; b < 2; b++){
      for(int e = 0; e < 2; e++){
        for(int s = 0; s < 2; s++){
          for(int i = 0; i < 2; i++){
            for(int g = 0; g < 2; g++){
              for(int o = 0; o < 2; o++){
                for(int m = 0; m < 2; m++){
                  if ( ((b+e+s+s+i+e)*(g+o+e+s)*(m+o+o)) % 2 == 0){
                     ans += cnt[0][b]  * cnt[1][e] * cnt[2][s] * cnt[3][i]  * cnt[4][g] * cnt[5][o]   * cnt[6][m]; 
                  }
                }
              }
            }
          }
        }
      }
    }
    
    pw.println(ans);
    pw.close();

  }

}
