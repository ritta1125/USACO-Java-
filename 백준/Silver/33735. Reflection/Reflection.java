//Reflection  (https://usaco.org/index.php?page=viewproblem2&cpid=1491 )
// https://www.acmicpc.net/problem/33735 

import java.io.*;
import java.util.*;

public class Main {  
  public static int N;
  public static char[][] canvas;
  
  public static void main(String[] args) throws IOException {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());

    N = Integer.parseInt(st.nextToken());
    int U = Integer.parseInt(st.nextToken());

    canvas = new char[N][N];

    for(int i = 0; i < N; i++){
      canvas[i] = r.readLine().toCharArray();
    }

    int opr = change();
    pw.println(opr);
    
    for(int i = 0; i < U; i++){
      st = new StringTokenizer(r.readLine());
      int y = Integer.parseInt(st.nextToken()) -1;
      int x = Integer.parseInt(st.nextToken()) -1;

      int dots = countDots(y, x);
      
      char tmp = canvas[y][x];
      if(tmp == '#') canvas[y][x] = '.';
      else canvas[y][x] = '#';

      opr -= dots - countDots(y, x); 

      pw.println(opr);
    }

    pw.close();
  }

  public static int countDots(int y, int x) {
    int dots = 0;
    
    if(canvas[y][x] == '.') dots++; //tl
    if(canvas[y][N-1 - x] == '.') dots++; //tr
    if(canvas[N-1 - y][x] == '.') dots++; //bl
    if(canvas[N-1 - y][N-1 - x] == '.') dots++; //br
      
    return Math.min(dots, 4-dots);
  }

  public static int change(){
    int tot = 0;
    
    for(int i = 0; i < N/2; i++){
      for(int j = 0; j < N/2; j++){
        tot += countDots(i,j);
      }
    }        

    return tot;
  }
}

/*
tl   tr
..#. .#..
..#. .#..
.##. .##.
.... ....
bl   br
.... ....
.##. .##.
..#. .#..
..#. .#..
*/