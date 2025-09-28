import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/14457 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    char[][] cows = new char[N][N];
    
    for(int i = 0; i < N; i++){
      cows[i] = r.readLine().toCharArray();
    }
    
    int count = 0;
    
    for(int i = N-1; i >= 0; i--){
      for(int j = N-1; j >= 0; j--){
        if(cows[i][j] == '1'){
          count++;
          
          for(int y = i; y >= 0; y--){
            for(int x = j; x >= 0; x--){
              cows[y][x] = cows[y][x] == '1'? '0':'1';
            }
          }
        }
      }
    }

    pw.print(count);
    pw.close();
  }
}