import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기값
        int e = 1;
        int s = 1;
        int m = 1;
        int result = 1;

        while (true) { // E, S, M을 찾을 때까지 반복
            if (e == E && s == S && m == M) break;

            e++;
            s++;
            m++;

            if (e == 16) e = 1; // E는 1부터 15까지 반복
            if (s == 29) s = 1; // S는 1부터 28까지 반복
            if (m == 20) m = 1; // M은 1부터 19까지 반복
            
            result++;
        }
        System.out.println(result);
    }
}
