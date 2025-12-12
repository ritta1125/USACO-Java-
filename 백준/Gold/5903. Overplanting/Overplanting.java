import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/5903  
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[][] rect = new int[N][4];
    ArrayList<Integer> X = new ArrayList<>();
    ArrayList<Integer> Y = new ArrayList<>();

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      rect[i][0] = x1;
      rect[i][1] = y1;
      rect[i][2] = x2;
      rect[i][3] = y2;

      X.add(x1);
      X.add(x2);
      Y.add(y1);
      Y.add(y2);
      
    }
    
    Collections.sort(X);
    Collections.sort(Y);

    int ans = 0; 
  

    for(int i = 0; i < X.size()-1; i++){
      for (int j = 0; j < Y.size()-1; j++) {
        int xl = X.get(i);
        int xr = X.get(i+1);
        int yb = Y.get(j);
        int yt = Y.get(j+1);

        double xc = (xl+xr)/2.0;
        double yc = (yb+yt)/2.0; 

        boolean check = false;


        for(int k = 0; k < N; k++){
          if(xc >= rect[k][0] && xc <= rect[k][2] 
          && yc >= rect[k][3] && yc <= rect[k][1]){
            check = true;
            break;
          }
        }

        if(check){
          ans += (xr-xl)*(yt-yb);
        }
      }
    }

    
    pw.print(ans);
    pw.close();
  }
}