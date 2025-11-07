import java.io.*;
import java.util.*;

public class Main {  
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int T = Integer.parseInt(r.readLine());

    for(int i = 0; i < T; i++){
      int N = Integer.parseInt(r.readLine());
      StringTokenizer st = new StringTokenizer(r.readLine());
      int[] arr = new int[N];

      for(int j = 0; j < N; j++){
        arr[j] = Integer.parseInt(st.nextToken());
      }

      int max = 0;
      long sum = 0;

      for(int j = N-1; j >= 0; j--){
        max = Math.max(max, arr[j]);
        sum += max - arr[j];
      }

      pw.println(sum);
    }

    pw.close(); 
  }
}
