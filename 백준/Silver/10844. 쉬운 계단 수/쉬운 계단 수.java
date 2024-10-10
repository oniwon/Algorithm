import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 1_000_000_000;

        long[][] dp = new long[n + 1][10]; // dp 배열: 길이가 i이고, 마지막 숫자가 j인 계단 수의 개수

        // 초기값
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % num; // 마지막 수가 0으로 끝나면, 이전 자리는 1
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % num; // 마지막 수가 9로 끝나면, 이전 자리는 8
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])% num; // 이외는 이전 자리가 j-1 또는 j+1
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
             answer = (answer + dp[n][i]) % num; // 길이가 n인 수 다 더하기
        }

        System.out.println(answer);
    }
}