import java.io.*;
import java.util.*;
            
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    StringTokenizer st = new StringTokenizer(r.readLine());
    int N = Integer.parseInt(st.nextToken());
    long K = Long.parseLong(st.nextToken());

    long[] days = new long[N];
    st = new StringTokenizer(r.readLine());
    for(int i = 0; i < N; i++){
      days[i] = Long.parseLong(st.nextToken());
    }

    long min = K+1 ;

    for(int i = 1; i < N; i++){ 
      min += Math.min(days[i] - days[i-1], K+1); 
    }

    pw.print(min);
    pw.close();
  }
}