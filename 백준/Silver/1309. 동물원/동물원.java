import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 9901;

        /*
        i번째 줄에 사자를 배치할 수 있는 경우의 수
        j = 0: i번째 줄에 사자를 배치하지 않는 경우
        j = 1: i번째 줄 왼쪽 칸에 사자를 배치하는 경우
        j = 2: i번째 줄 오른쪽 칸에 사자를 배치하는 경우
        */
        int[][] dp = new int[n + 1][3];

        // 초기값
        for(int i = 0; i < 3; i++) {
            dp[1][i] = 1; // n=1일 때 배치할 수 있는 사자 수: 각각 1
        }


        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod; // 사자를 배치하지 않을 경우 이전 줄의 경우과 같음
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod; // 왼쪽 칸에 사자를 배치할 경우 이전 줄에서 사자 배치 X or 오른쪽에 배치
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod; // 오른쪽 칸에 사자를 배치할 경우 이전 줄에서 사자 배치 X or 왼쪽에 배치
        }

        int answer = (dp[n][0] + dp[n][1] + dp[n][2]) % mod;
        System.out.println(answer);
    }
}