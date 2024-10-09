import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; // dp 배열

        // 초기값
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007; // dp[i - 1]에서 1*2 타일 붙이기 + dp[i - 2]에서 1*2 두개, 2*2 타일 붙이기
        }
        System.out.println(dp[n]);
    }
}