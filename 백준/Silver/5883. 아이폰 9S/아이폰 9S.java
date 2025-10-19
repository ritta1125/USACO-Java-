import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    int[] ids = new int[N];

    for(int i = 0; i < N; i++){
      ids[i] = Integer.parseInt(r.readLine());
    }

    int max = 1;
    for(int i = 0; i < N; i++){
      int remove = ids[i];
      int count = 1;
      int curr = -1;
      
      for(int j = 0; j < N; j++){
        if(ids[j] == remove) continue;
        if(ids[j] == curr) count++;
        else {
          max = Math.max(count, max);
          curr = ids[j];
          count = 1;
        }
      }
      max = Math.max(count, max);
    }

    pw.print(max);
    pw.close();
  }
}