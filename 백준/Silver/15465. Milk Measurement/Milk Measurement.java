import java.io.*;
import java.util.*;

public class Main {
    static class Log {
        int day;
        String cow;
        int change;

        Log(int day, String cow, int change){
            this.day = day;
            this.cow = cow;
            this.change = change;
            
        }
    }
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/15465
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());

        ArrayList<Log> log = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            log.add(new Log(Integer.parseInt(st.nextToken()),st.nextToken(),Integer.parseInt(st.nextToken())));
        }

        log.sort(Comparator.comparingInt(l -> l.day));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bessie", 7);
        map.put("Elsie", 7);
        map.put("Mildred", 7);

        int max = 0;
        int count = 0;
        HashSet<String> maxCow= new HashSet<>(); 
        
        
        for(Log l : log) {
            map.put(l.cow, l.change + map.get(l.cow));
            HashSet<String> tmp = new HashSet<>(); 
            max = Collections.max(map.values());

            for(Map.Entry<String,Integer> c : map.entrySet()) {
                if (c.getValue() == max) {
                    tmp.add(c.getKey());
                } 
            }

            if (!tmp.equals(maxCow)) {
                count++;
                maxCow = tmp; 
            }
        }

        pw.print(count);
        pw.close();
  }
}