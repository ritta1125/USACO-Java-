import java.awt.Insets;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/18269 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        String S = r.readLine();
        int num = N;
        
        for(int i = 1; i < S.length() + 1; i++){
            HashSet<String> set = new HashSet<>();       
            boolean check = true;
                
            for(int j = 0; j <= S.length() - i; j++){
                boolean repeat = set.add(S.substring(j, j + i));

                if(!repeat) {
                    check = false;
                    break;
                }
            }

            if (check) {
                num = i;
                break;
            }
        }
    
        pw.print(num); 
        pw.close();
  }
}