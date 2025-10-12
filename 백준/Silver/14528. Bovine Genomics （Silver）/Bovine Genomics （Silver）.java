import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    char[][] spotty = new char[N][M];
    for(int i = 0; i < N; i++){
      spotty[i] = r.readLine().toCharArray();
    }

    char[][] plain = new char[N][M];
    for(int i = 0; i < N; i++){
      plain[i] = r.readLine().toCharArray();
    }

    int count = 0;
    
    for(int x = 0; x < M-2; x++){
      for(int y = x+1; y < M-1; y++){
        for(int z = y+1; z < M; z++){
          HashSet<String> set = new HashSet<>();
          for(int i = 0; i < N; i++){
            String tmp = new String(new char[]{spotty[i][x], spotty[i][y], spotty[i][z]});
            set.add(tmp);
          }

          boolean is = true;
          for(int i = 0; i < N; i++){
            String tmp = new String(new char[]{plain[i][x], plain[i][y], plain[i][z]});
            if(set.contains(tmp)) {
              is = false;
              break;
            }
          }

          if(is) count++;
        }
      }
    }
    
    pw.print(count);
    pw.close();
  }
}