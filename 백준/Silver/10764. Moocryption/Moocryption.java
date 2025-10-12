import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] puzzle = new char[N][M];

    for(int i = 0; i < N; i++){
      puzzle[i] = r.readLine().toCharArray();
    }

    int[] dx = {-1,-1,-1,0,0,1,1,1};
    int[] dy = {-1,0,1,-1,1,-1,0,1};
    /*
    0 3 5
    1   6
    2 4 7
    */
    HashMap<String, Integer> map = new HashMap<>();

    for(int y = 0; y < N; y++){
      for(int x = 0; x < M; x++){
        for(int i = 0; i < 8; i++){
          char tmp0 = puzzle[y][x];
          if (!(y+2*dy[i]>=0 && y+2*dy[i]<N && x+2*dx[i]>=0 && x+2*dx[i]<M)) continue;
          char tmp1 = puzzle[y+dy[i]][x+dx[i]];
          char tmp2 = puzzle[y+2*dy[i]][x+2*dx[i]];
          
          if(tmp1 == tmp2 && tmp0 != tmp1 && tmp0 != 'M' && tmp1 != 'O'){
            String key = new String(new char[]{tmp0,tmp1,tmp2});
            map.put(key, map.getOrDefault(key, 0)+1);
          }
        }
      }
    }    
    
    
    int max = 0;
    for(int i: map.values()){
      max = Math.max(i, max);
    }
    
    pw.print(max);
    pw.close();
  }
}
