import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/1931 
  
  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(r.readLine());
    int[][] meeting = new int[N][2];

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      meeting[i][0] = Integer.parseInt(st.nextToken());
      meeting[i][1] = Integer.parseInt(st.nextToken());
    }

    // 두번째 값을 기준으로 오름차순 정렬하는 코드 
    Arrays.sort(meeting, (a,b) -> {
      if (a[1] == b[1] ) return a[0] - b[0];
      return a[1] - b[1];
    });


    int prev = 0;
    int count = 1;

    for(int i = 1; i < N; i++){
      if(meeting[prev][1] <= meeting[i][0]){
        prev = i;

        count++;
      }
    }

    pw.print(count);
    pw.close();
  }

  
}