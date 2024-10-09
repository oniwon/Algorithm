import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num = 1000000009;
        long[][] dp = new long[100001][4]; // n은 양수이며 100,000보다 작거나 같음

        // 초기값
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;

        // dp 배열 채우기
        for (int i = 4; i <= 100000; i++) {
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % num; // 마지막에 3을 더한 경우
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % num; // 마지막에 2를 더한 경우
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % num; // 마지막에 1을 더한 경우
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long answer = ((dp[n][1] + dp[n][2] + dp[n][3])) % num; // 위의 경우의 수 다 더하기
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}