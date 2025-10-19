import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    HashMap<String, Integer> names = new HashMap<>();
    st = new StringTokenizer(r.readLine());    
    for(int i = 0; i < N; i++){
      names.put(st.nextToken(),i);
    }

    char[][] output = new char[N][N];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        output[i][j] = '?';
      }
      output[i][i] = 'B';
    }

    for(int a = 0; a < K; a++){
      st = new StringTokenizer(r.readLine());
      String[] tmp = new String[N];

      for(int b = 0; b < N; b++){
        tmp[b] = st.nextToken();
      }

      for(int i = 0; i < N-1; i++){
        boolean check = false;
        for(int j = i+1; j < N; j++){
          if ( tmp[j-1].compareTo(tmp[j]) > 0 ) check = true; 
          if (check) {
            int p1 = names.get(tmp[j]);
            int p2 = names.get(tmp[i]);
            output[p1][p2] = '1';
            output[p2][p1] = '0';
          }
        }
      }      
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        pw.print(output[i][j]);
      }
      pw.println("");
    }
    
    pw.close();
  }
}