import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
//            int[] dp = new int[n + 1]; //동적 생성 => 런타임 에러
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }
            sb.append(dp[n]).append("\n");

        }
        System.out.println(sb);
    }
}