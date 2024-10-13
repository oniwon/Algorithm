import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        int mod = 1_000_000_009;
        int maxN = 1000000;
        
        // dp 배열을 미리 계산
        long[] dp = new long[maxN + 1];
        // 초기값
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= maxN; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % mod;
        }
      
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}