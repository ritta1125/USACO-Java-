import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/14174 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        HashMap<String, Integer> cows = new HashMap<>();

        cows.put("Bessie", 0);
        cows.put("Elsie", 0);
        cows.put("Daisy", 0);
        cows.put("Gertie", 0);
        cows.put("Annabelle", 0);
        cows.put("Maggie", 0);
        cows.put("Henrietta", 0);
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            String name = st.nextToken();
            int milk = Integer.parseInt(st.nextToken()) + cows.getOrDefault(name, 0);
            cows.put(name, milk);
        }

        ArrayList<Integer> milk = new ArrayList<>(cows.values());

        Collections.sort(milk);
    
        int min = milk.get(0);
        boolean isTie = false;

        for(int i: milk){
            if(i > milk.get(0)) {
                min = i;
                break;
            } 
        }

        if(milk.indexOf(min) != milk.lastIndexOf(min)) pw.print("Tie");
        else{
            for(String s: cows.keySet()){
                    if(cows.get(s) == min) pw.print(s);
            }
        }

        
        
        pw.close();
  }
}