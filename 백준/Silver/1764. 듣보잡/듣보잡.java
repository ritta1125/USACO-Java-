import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1764 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> eme = new HashSet<>();
        ArrayList<String> emeqh = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            eme.add(r.readLine());
        }
        
        for(int i = 0; i < M; i++){
            String qh = r.readLine();
            if(eme.contains(qh)){
                emeqh.add(qh);
            }
        }

        pw.println(emeqh.size());

        
        Collections.sort(emeqh);
        for(String s: emeqh){
            pw.println(s);
        }

        pw.close();
    }
}