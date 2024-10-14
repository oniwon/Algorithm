import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int mod = 1_000_000_000;

        int[][] dp = new int[k + 1][n + 1];

        // 초기화
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1; // i개의 숫자로 합이 0인 경우는 1
        }

        for (int i = 1; i <= k; i++) { // 숫자의 개수
            for (int j = 1; j <= n; j++) { // 합
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod; // dp[i - 1][j] 앞에 0을 더한 수 + dp[i][j - 1] 앞에 1을 더한 수 
            }
        }

        System.out.println(dp[k][n] % mod);
    }
}
