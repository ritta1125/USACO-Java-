
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    Arrays.sort(arr);
    int max = 0;

    for(int i = 0; i < N; i++){
      int tmp = 1;
      int exp = 1;
      int l = i , r = i;
      int lp = i, rp = i; 
      boolean lf = true, rf = true; 


      while(true) {
        int lc = 0, rc = 0; 

        while (l-1 >= 0 && arr[l-1] >= arr[lp] - exp && lf ) {
          tmp++;
          l--;
          lc++;
        }

        while (r+1 < N && arr[r+1] <= arr[rp] + exp && rf) {
          tmp++;
          r++;
          rc++;
        }

        if (lc ==0) lf = false; 
        if (rc == 0) rf = false;

        lp = l;
        rp = r; 

        if (lc != 0 || rc != 0){
          exp++;
        }
        else {
          break;
        }
      }
      max = Math.max(tmp, max);
    }    
    

    pw.print(max);
    pw.close();
  }
}