
// 온라인 수업 링크 : 
// https://meet.google.com/zcb-fbdi-bwv
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // https://www.acmicpc.net/problem/15593 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());    
    int max = 0;
    int[] start = new int[N];
    int[] end = new int[N];

    for(int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());
      start[i] = Integer.parseInt(st.nextToken());
      end[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      int[] time = new int[1001]; // 1. time 만들기 ([0] * 1001) 
      for (int j = 0; j < N; j++) {
        if (i == j) continue; // 2. 해고할 라이프가드 한명 고르기
        for (int k = start[j]; k < end[j]; k++){
          time[k] = 1;
        } // 3. 2번의 가드만 빼고 나머지 가드의 시간 업데이트 하기 ex. time[j] = 1 
      }
      
      int total = 0;
      for(int k = 0; k < 1001; k++){
        total += time[k];
      }
      // 4. total_time 구하기 
      max = total > max? total: max;
  
    }    
    // 5. max_total_time 구하기 

    pw.print(max);
    
    pw.close();
    
  }

}