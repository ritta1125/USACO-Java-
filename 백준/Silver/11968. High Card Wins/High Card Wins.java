import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/11968 

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] cards = new int[2*N];
    
    for(int i = 0; i < N; i++){
      int tmp = Integer.parseInt(r.readLine());
      cards[tmp-1] = 1;
    }
    
    int win = 0;
    
    for(int i = 0; i < 2*N; i++){
      if(cards[i] == 1){
        for(int j = i; j < 2*N; j++){
          if(cards[j] == 0){
            cards[j] = 2;
            win++;
            break;
          }
        }
      }
    }

    pw.print(win);
    pw.close();
  }
}