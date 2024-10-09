import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11]; // n은 양수이며 11보다 작으므로

            dp[1] = 1; // 1
            dp[2] = 2; // 1+1, 2
            dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
            for(int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3]; // dp[j - 1] 에서 1더하기 + dp[j - 2]에서 2더하기 + dp[j - 3]에서 3더하는 경우의 수
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}