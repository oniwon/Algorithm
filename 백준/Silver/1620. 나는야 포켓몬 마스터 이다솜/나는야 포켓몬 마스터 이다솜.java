import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 시간복잡도를 고려해 맵 두개 만들기
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> reverseMap = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(i, s);
            reverseMap.put(s, i);
        }

        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(49 <= s.charAt(0) && s.charAt(0) <= 57) { // 숫자에 해당하면 문자 출력
                int j = Integer.parseInt(s);
                System.out.println(map.get(j));
            } else {
                System.out.println(reverseMap.get(s)); // 문자이면 숫자 출력
            }
        }
    }
}
