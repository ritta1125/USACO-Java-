import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/20974 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(r.readLine());
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(r.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int odd = 0;
        int even = 0;

        for(int i = 0; i < N; i++){
            int curr = num[i];
            if(curr % 2 == 0) even++;
            else odd++;
        }

        while (odd > even) {
            odd -= 2;
            even++;
        }
        
        if (odd == even) {
            pw.println(odd + even );
        }else{
            pw.println(odd * 2 + 1 );
        }
            
        pw.close();
  }
}
