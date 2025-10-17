import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[] colors = new int[c];
    
    st = new StringTokenizer(r.readLine());
    for(int i = 0; i < c; i++){
      colors[i] = Integer.parseInt(st.nextToken());
    }

    int[][] board = new int[h][w];
    int count = 1;
    int idx = 0;
    
    for(int x = 0; x < w; x++){
      for(int y = 0; y < h ; y++){
        board[y][x] = idx+1;

        if (count >= colors[idx]){
          idx++;
          count = 0;
        } 
        count++;
      }
    }

    for(int x = 0; x < h; x++){
      for(int y = 0; y < w; y++){
        pw.print(board[x][y]);
      }
      pw.println("");
    }
  
    pw.close();
  }
}