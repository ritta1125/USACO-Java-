import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/9872 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String[] arr = r.readLine().split(" ");

            Arrays.sort(arr);

            String tmp = String.join(" ", arr);

            

            if(map.containsKey(tmp)) map.put(tmp, map.get(tmp) + 1);
            else map.put(tmp, 1);
        }

        int max = 0;
        for(String s: map.keySet()){
            int tmp = map.get(s);
            max = tmp > max? tmp: max;
        }

        pw.print(max);
        pw.close();
    }
}