import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/17029 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        HashSet<String>[] set = new HashSet[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            
            st.nextToken();
            int K = Integer.parseInt(st.nextToken());
            set[i] = new HashSet<>();
            
            for(int j = 0; j < K; j++){
                set[i].add(st.nextToken());
            }
        }

        int max = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                HashSet<String> tmp = new HashSet<>(set[i]);
                tmp.retainAll(set[j]);

                if(tmp.size() > max) max = tmp.size();
            }
        }
        
        pw.print(max + 1);
        pw.close();
    }
}