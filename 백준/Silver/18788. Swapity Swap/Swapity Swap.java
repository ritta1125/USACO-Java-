import java.io.*;
import java.util.*;

public class Main {
  //https://www.acmicpc.net/problem/18788  

  public static void reverse(int[] arr, int s, int e){
    while (s < e) {
      int tmp = arr[s];
      arr[s] = arr[e];
      arr[e] = tmp;
      s++;
      e--;
    }
  }

  public static void main(String[] args) throws IOException {
    PrintWriter pw = new PrintWriter(System.out);
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N+1];

    for(int i = 0; i <= N; i++){
      arr[i] = i;
    }

    st = new StringTokenizer(r.readLine());
    int A1 = Integer.parseInt(st.nextToken());
    int A2 = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(r.readLine());
    int B1 = Integer.parseInt(st.nextToken());
    int B2 = Integer.parseInt(st.nextToken());

    //HashSet을 쓰면 사이클을 쉽게 체크할 수 있다! 
    HashSet<String> set = new HashSet<>(); 
    String start = Arrays.toString(arr);
    set.add(start);
    
    // 사이클 찾기 (loops)
    while(true){
      reverse(arr, A1, A2); 
      reverse(arr, B1, B2);
      
      String tmp = Arrays.toString(arr);
      if(set.contains(tmp)){
        break;
      }else {
        set.add(tmp);
      }
    }

    // 사이클을 찾았다면? -> arr 다시 초기화 한다 (1~N+1) 
    for(int i = 0; i <= N; i++){
      arr[i] = i;
    }

    // times =  K % cycle
    int times = K % set.size();
    
    // times만큼 스텝을 반복 
    for(int i = 0; i < times; i++){
      reverse(arr, A1, A2); 
      reverse(arr, B1, B2);
    }

    //반복이 끝나고 나면 문제에서 원하는 답(숫자의 순서/배열)이 arr 에 저장되어 있다. 
    for(int i = 1; i <= N; i++){
      pw.println(arr[i]);
    }
    
    pw.close();
  }
}