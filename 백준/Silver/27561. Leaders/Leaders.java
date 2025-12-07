import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/27561  
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    String cows = r.readLine();
    int[] E = new int[N];
    StringTokenizer st = new StringTokenizer(r.readLine());

    int H_i = cows.indexOf('H');
    int H_f = cows.lastIndexOf('H');
    int G_i = cows.indexOf('G');
    int G_f = cows.lastIndexOf('G');

    for(int i = 0; i < N; i++){
      E[i] = Integer.parseInt(st.nextToken());
    }

    int Hcnt = 0, Gcnt = 0;

    //G(H) 를 모두 포함해서 리더가 되는 케이스 
    if (E[H_i]-1 >= H_f) Hcnt++;
    if (E[G_i]-1 >= G_f) Gcnt++;

    //다른 종의 리더를 포함해서 리더가 되는 케이스 
    for(int i = 0; i < N; i++){
      char c = cows.charAt(i);
      

      if (c == 'H') {
         if(i <= G_i && G_i <= E[i]-1 ){
           if ( !((i == H_i) && (E[H_i] - 1 >= H_f)) ) {
             Hcnt++;
           }
         }        
      }
      else {
        if( i <= H_i && H_i <= E[i]-1 ){
          if (!((i == G_i) && (E[G_i] - 1 >= G_f)) )  {
            Gcnt++;
          }
        }  
      }
    }

    pw.println(Hcnt * Gcnt);
    pw.close();
  }
}