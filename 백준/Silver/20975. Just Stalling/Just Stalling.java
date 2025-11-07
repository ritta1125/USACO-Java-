import java.io.*;
import java.util.*;


public class Main {  
  //https://www.acmicpc.net/problem/20975 
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    Integer[] h = new Integer[N];
    Integer[] lim = new Integer[N];

    StringTokenizer st = new StringTokenizer(r.readLine());
    for(int i = 0; i < N; i++){
      h[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(r.readLine());
    for(int i = 0; i < N; i++){
      lim[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(h, Collections.reverseOrder());
    Arrays.sort(lim,Collections.reverseOrder());

    long num = 1;
    for(int i = 0; i < N; i++){
      int count = 0;

      for(int j = 0; j < N; j++){
        if(h[i] <=lim[j]) count++;
        else break; 
      }

      num *= count-i;
    }

    pw.println(num);
    pw.close(); 
  }
}