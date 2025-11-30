import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/33736 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] arr = new int[N+1];
    StringTokenizer st = new StringTokenizer(r.readLine());

    for(int i = 0; i < N; i++){
      int tmp = Integer.parseInt(st.nextToken());
      arr[tmp]++;
    }

    int count0 = 0;

    for(int i = 0; i <= N; i++){
        int ans = Math.max(arr[i], count0);
        int tmp = arr[i];
        if(tmp == 0) count0++;
        pw.println(ans);
    }

    pw.close();
  }
}

