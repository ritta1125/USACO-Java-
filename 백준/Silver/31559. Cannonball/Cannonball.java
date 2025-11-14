import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/31559
  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N+1][2];

    int k = 1;
    int d = 1;
    int count = 0;

    for(int i = 1; i <= N; i++){
      st = new StringTokenizer(r.readLine());
      int q = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      arr[i][0] = q;
      arr[i][1] = v;
    }

    for(int i = 0; i < 1_000_000; i++) { //좌표 / 반복 횟수 
      if (S > N || S < 1) break; 
      //내 위치 --> S 
      if(arr[S][0] ==0){ // Jump
        //파워가 늘어나고 
        k += arr[S][1];
        //방향이 바뀌고 
        d *= -1;
        
      }else { // target 
        if(arr[S][1] <= k &&  arr[S][1] != -1){
          count++;
          arr[S][1] = -1;
        }
      }

      S += d * k;

      
    }
    pw.println(count);
    pw.close();
  }
}