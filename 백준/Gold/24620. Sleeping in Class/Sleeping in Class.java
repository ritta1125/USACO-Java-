import java.io.*;
import java.util.*;

public class Main {  
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int T = Integer.parseInt(r.readLine());   
    
    for(int i = 0; i < T; i++){
      int N = Integer.parseInt(r.readLine());
      int[] log = new int[N];
      int sum = 0;
      
      StringTokenizer st = new StringTokenizer(r.readLine());
      for(int j = 0; j < N; j++){
        log[j] = Integer.parseInt(st.nextToken());
        sum += log[j];
      }   
      
      for(int n = N; n > 0; n--){
        if(sum % n == 0){
          boolean is = true;
          int target = sum/n;
          int tmp = 0;
          
          for(int x = 0; x < N; x++){
            tmp += log[x];

            if(tmp > target){
              is = false;
              break;
            } else if (tmp == target){
              tmp = 0;
            }      
          }

          if(is) {
            pw.println(N-n);
            break; 
          }
          
        }
      }
    }
      
    
    pw.close();
  }
}