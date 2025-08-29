import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/1620
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> names = new HashMap<>();
        HashMap<Integer, String> nums = new HashMap<>();

        for(int i = 1; i < N+1; i++){
            String tmp = r.readLine();
            names.put(tmp, i);
            nums.put(i, tmp);
        }

        for(int i = 0; i < M; i++){
            String tmp = r.readLine();
            int isName = names.getOrDefault(tmp, 0);
            if(isName != 0) pw.println(isName);
            else pw.println(nums.get(Integer.parseInt(tmp)));
        }

        pw.close();
    }
}