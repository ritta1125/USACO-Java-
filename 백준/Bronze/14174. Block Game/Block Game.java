import java.awt.Insets;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] count(String word) {
        int[] freq = new int[26];
        for (char a : word.toCharArray()) {
            freq[a - 'a'] += 1;
        }
        return freq;
    }
    
    public static void main(String[] args) throws IOException {
        //https://www.acmicpc.net/problem/14174 
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int N = Integer.parseInt(r.readLine());
        int[] letters = new int[26];

        for(int i = 0; i < N; i++){
            int[] letters1 = new int[26];
            int[] letters2 = new int[26];
            
            StringTokenizer st = new StringTokenizer(r.readLine());

            for(char c: st.nextToken().toCharArray()){
                letters1[c - 'a'] += 1;
            }

            for(char c: st.nextToken().toCharArray()){
                letters2[c - 'a'] += 1;
            }

            for(int j = 0; j < 26; j++){
                letters[j] += letters1[j] > letters2[j]? letters1[j]: letters2[j];
            }

        }

        for(int i = 0; i < 26; i++){
            pw.println(letters[i]);
        }

        pw.close();
  }
}