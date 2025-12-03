import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        String sLine = br.readLine().trim();
        char[] s = sLine.toCharArray();

        // pattern_count : 원본 문자열에서 나온 xYY 패턴 카운트
        Map<String, Integer> patternCount = new HashMap<>();

        for (int i = 0; i <= N - 3; i++) {
            char a = s[i];
            char b = s[i + 1];
            char c = s[i + 2];
            if (b == c && a != b) {
                String pat = new String(new char[]{a, b, c});
                patternCount.put(pat, patternCount.getOrDefault(pat, 0) + 1);
            }
        }

        // 결과 패턴들 저장
        HashSet<String> resultSet = new HashSet<>();

        for (Map.Entry<String, Integer> e : patternCount.entrySet()) {
            if (e.getValue() >= F) {
                resultSet.add(e.getKey());
            }
        }

        // 각 위치를 다른 알파벳으로 바꿔보며 검사
        for (int i = 0; i < N; i++) {

            char orig = s[i];

            int startL = Math.max(0, i - 2);
            int startR = Math.min(N - 3, i);

            // 원래 문자열에서 이 위치가 포함된 패턴들
            Map<String, Integer> oldPatterns = new HashMap<>();
            for (int start = startL; start <= startR; start++) {
                char a = s[start];
                char b = s[start + 1];
                char c = s[start + 2];
                if (b == c && a != b) {
                    String pat = new String(new char[]{a, b, c});
                    oldPatterns.put(pat, oldPatterns.getOrDefault(pat, 0) + 1);
                }
            }

            // 알파벳 26개 테스트: 'a' + k 형태로 변경
            for (int k = 0; k < 26; k++) {
                char ch = (char) ('a' + k);
                if (ch == orig) continue;

                s[i] = ch;  // 한 글자 바꿔놓고

                Map<String, Integer> newPatterns = new HashMap<>();
                for (int start = startL; start <= startR; start++) {
                    char a = s[start];
                    char b = s[start + 1];
                    char c = s[start + 2];
                    if (b == c && a != b) {
                        String pat = new String(new char[]{a, b, c});
                        newPatterns.put(pat, newPatterns.getOrDefault(pat, 0) + 1);
                    }
                }

                // total = 전체 - old + new
                for (Map.Entry<String, Integer> e : newPatterns.entrySet()) {
                    String pat = e.getKey();
                    int cntNew = e.getValue();

                    int base = patternCount.getOrDefault(pat, 0);
                    int oldLocal = oldPatterns.getOrDefault(pat, 0);

                    int total = base - oldLocal + cntNew;

                    if (total >= F) {
                        resultSet.add(pat);
                    }
                }
            }

            // 복원
            s[i] = orig;
        }

        // 정렬 출력
        ArrayList<String> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);

        out.println(resultList.size());
        for (String pat : resultList) {
            out.println(pat);
        }

        out.flush();
    }
}
