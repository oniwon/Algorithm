import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // 의상 이름 버리기
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1); // 의상 개수 +1
            }

            int result = 1;
            for (int count : map.values()) {
                result *= (count + 1); // 의상 입지 않는 경우 +1
            }
            System.out.println(result - 1); // 알몸인 상태 -1
        }
    }
}