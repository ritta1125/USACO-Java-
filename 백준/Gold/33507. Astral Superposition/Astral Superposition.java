import java.io.*;
import java.util.*;

public class Main {

  /*
  f[str] := Module[{s = str },
  l = Characters[s];
  ans = 0 ;
  For[i = 1, i < StringLength[s], i++, ans +=  Abs[LetterNumber[l[[i]]] -  LetterNumber[l[[i+1]]] ]];
  ans
    ]

    Print[f["wolfram"]]
  */
  public static void main(String[] args) throws IOException {
    //https://www.acmicpc.net/problem/33507  
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);

    int T = Integer.parseInt(r.readLine()); 

    for(int i = 0; i < T; i++){
      StringTokenizer st = new StringTokenizer(r.readLine());

      int N = Integer.parseInt(st.nextToken()); 
      int A = Integer.parseInt(st.nextToken()); //r
      int B = Integer.parseInt(st.nextToken()); //d

      String[][] si = new String[N][N];
      
      for(int j = 0; j < N; j++){
        si[j] = r.readLine().split("");
      }

      int[][] org = new int[N][N];
      int ans = 0;
      boolean isTrue = true;

      for(int y = 0; y<N; y++){
        for(int x = 0; x<N; x++){
          int py = y - B;
          int px = x - A;

          // -B,-A 포지션에서 별이 이동해왔는가? 를 체크하는 변수 
          boolean move = (py >= 0 && px >= 0  && org[py][px] == 1);
            
          if(si[y][x].equals("B")){
            // 검은색이면 무조건 지금 자리에 별이 있어야 한다
            org[y][x] = 1; 

            // 이동해온 자리에도 별이 있어야 한다!! 
            if (!move) {
              if (py <0 || px < 0 || si[y-B][x-A].equals("W")){
                // 맵 밖이거나, W이면 실패 
                isTrue = false;
                break;
              }
              org[py][px] = 1; 
            }
          } else if(si[y][x].equals("G")){
            // 회색인데 이동한 별이 없다면 --> 기존에 이 자리에 별이 있었어야 한다!! (사라진 케이스) 
            if(!move) 
              org[y][x] = 1; 
          }
        }

        if(!isTrue) break;
      }

      if(!isTrue){
        pw.println(-1);
        continue;
      }
      
      for(int y = 0; y<N; y++){
        for(int x = 0; x<N; x++){
          ans += org[y][x];
        }
      }

      pw.println(ans);
    }
    
    pw.close();
  }
}