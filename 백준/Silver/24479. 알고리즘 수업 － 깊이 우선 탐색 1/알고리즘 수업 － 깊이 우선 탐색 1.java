import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] check;
  static int count;

  public static void DFS(int R){
    check[R] = count;

    for(int i = 0; i < graph.get(R).size(); i++){
      int newN = graph.get(R).get(i); 

      if(check[newN] == 0){
        count++;
        DFS(newN);
      }
    }
  }

  
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/24479

    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    check = new int[N + 1];

    for(int i = 0; i < N+1; i++){
      graph.add(new ArrayList<>());
    }

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(r.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    for(int i = 0; i < graph.size(); i++){
      Collections.sort(graph.get(i));
    }

    count = 1;

    DFS(R);

    for(int i = 1; i < check.length; i++){
      pw.println(check[i]);
    }
    
    pw.close();
  }
}