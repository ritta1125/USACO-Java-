import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/24622 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        String[] blocks = new String[4];

        for(int i = 0; i < 4; i++){
            blocks[i] = r.readLine();
        }
        
        for(int i = 0; i < N; i++){
            String word = r.readLine();
            boolean check = false;

            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(k == j) continue;
                    for(int l = 0; l < 4; l++){
                        if(l == k || l == j) continue;
                        for(int m = 0; m < 4; m++){
                            if(m == l || m == k || m == j) continue;

                            boolean is = true;
                            int[] choose = {j,k,l,m};
                            int cidx = 0;

                            for(char c: word.toCharArray()){
                                String block = blocks[choose[cidx]];
                                is = block.indexOf(c) == -1? false: true;

                                if(!is){
                                    break;
                                }
                                cidx++; 
                            }
                            
                            if(is){
                                pw.println("YES");
                                check = true;
                                break;
                            }
                        }
                        if(check){
                            break;
                        } 
                    }
                    if(check){
                        break;
                    }
                }
                if(check){
                    break;
                }
            }
            if (!check) pw.println("NO");
        }

        
        pw.close();
    }
}