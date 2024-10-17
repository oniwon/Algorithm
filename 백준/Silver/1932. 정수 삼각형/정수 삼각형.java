import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n + 1][n + 1]; // 삼각형 저장할 배열
        int[][] dp = new int[n + 1][n + 1];

        // 입력받은 삼각형 배열 채우기
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열: 삼각형의 마지막 행으로 초기화
        for (int j = 1; j <= n; j++) {
            dp[n][j] = triangle[n][j];
        }

        // bottom-up 방식
        for (int i = n - 1; i >= 1; i--) { // i는 n-1부터 1까지
            for (int j = 1; j <= i; j++) { // j는 1부터 i까지
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[1][1]);
    }
}
