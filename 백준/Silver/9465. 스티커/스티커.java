import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][n + 1]; // 스티커 점수 배열
            int[][] dp = new int[2][n + 1];

            // 스티커 점수 입력 받기
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값: 자기 자신의 값으로
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j]; // 왼쪽 대각선 아래값, 왼쪽 대각선 아래의 왼쪽값 중 최대값을 자기와 더해주기
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j]; // 왼쪽 대각선 위값, 왼쪽 대각선 위의 왼쪽값 중 최대값을 자기와 더해주기
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}