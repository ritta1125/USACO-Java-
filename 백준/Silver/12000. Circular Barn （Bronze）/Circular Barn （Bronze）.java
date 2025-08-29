import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/12000
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        int[] rooms = new int[N];
        int total = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(r.readLine());
            rooms[i] = tmp;
            total += tmp;
        }

        for(int i = 0; i < N; i++){
            int tmp = 0;
            int tmp_total = total;

            for(int j = i; j < N + i; j++){
                int k = j >= N? j % N : j;
                tmp += tmp_total - rooms[k];
                tmp_total -= rooms[k];
            }
            if(tmp <= min) min = tmp;
        }

        pw.print(min);
        pw.close();
    }
}