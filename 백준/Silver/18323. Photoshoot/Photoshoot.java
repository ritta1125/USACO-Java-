import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    StringTokenizer st = new StringTokenizer(r.readLine());
    int[] b = new int[N-1];
    

    for(int i = 0; i < N-1; i++){
      b[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 1; i < b[0]; i++){
      int[] a = new int[N];
      a[0] = i;
      boolean is = true;
      
      for(int j = 0; j < N-1; j++){
        int tmp = b[j] - a[j];
        if(tmp > 0) {
          a[j+1] = tmp;
          
          for(int k = 0; k < j+1; k++){
            if(tmp == a[k]) {
              is = false;
              break;
            }
          }
        }
        else {
          is = false;
          break;
        }
      }

      if(is){
        for(int j = 0; j < N; j++){
          pw.print(a[j] + " ");
        }
        break;
      }
    }

    pw.close();
  }
}