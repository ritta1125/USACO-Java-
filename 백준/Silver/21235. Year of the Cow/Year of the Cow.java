import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/21235 
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int N = Integer.parseInt(r.readLine());
    HashMap<String, String> aMap = new HashMap<>();
    HashMap<String, Integer> diffMap = new HashMap<>();
    ArrayList<String> animals = new ArrayList<>( Arrays.asList(
            "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse",
            "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
    ));

    aMap.put("Bessie", "Ox");
    diffMap.put("Bessie", 0);
    
    for(int i = 0; i < N; i++){
      String[] tmp = r.readLine().split(" ");

      String cow1 = tmp[0];
      String order = tmp[3];
      String animal = tmp[4];
      String cow2 = tmp[7];

      String target = aMap.get(cow2);
      int targetDiff = diffMap.get(cow2);

      int cnt = 0; 
      boolean check = false;

      if (order.equals("previous")) {
        for (int j = 24; j >= 0; j--) {
          if(check) {
            cnt--;
             if (animals.get(j%12).equals(animal)) break;
          }

          if (animals.get(j%12).equals(target)) check = true;
        }
      }
      else {
        for (int j = 0; j < 24; j++) {

          if(check) {
            cnt++;
             if (animals.get(j%12).equals(animal)) break;
          }

          if (animals.get(j%12).equals(target)) check = true;

        }
      }

      aMap.put(cow1, animal);
      diffMap.put(cow1, targetDiff+cnt);
    }
    pw.println(Math.abs(diffMap.get("Elsie")));
    
    pw.close();
  }
}