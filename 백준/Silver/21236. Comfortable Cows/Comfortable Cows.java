import java.io.*;
import java.util.*;

public class Main {
  static int[][] cell = new int[1001][1001];
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  
  public static boolean check(int x,int y) {
    if (cell[x][y] == 0) return false;
    int res = 0;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if ( (0<= nx && nx <= 1000) && (0<= ny && ny <=1000) )  {
        if (cell[nx][ny] == 1) res++;
      }
    }
    return res == 3; 
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());   
    int ans = 0; 
    

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      for (int j = 0; j < 4; j++) {
        int nx = x + dx[j];
        int ny = y + dy[j];
        if ( (0<= nx && nx <= 1000) && (0<= ny && ny <=1000) )  {
          if (check(nx,ny)) ans--;
        }
        
      }
      

      cell[x][y] = 1;
      if (check(x, y)) ans++;

      for (int j = 0; j < 4; j++) {
        int nx = x + dx[j];
        int ny = y + dy[j];
        if ( (0<= nx && nx <= 1000) && (0<= ny && ny <=1000) )  {
          if (check(nx,ny)) ans++;
        }

      }

      pw.println(ans); 
    }
    
    pw.close();
  }
}