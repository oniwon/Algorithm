import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) break;

                int nextI = arr[i][j] + i; // 아래로 점프
                int nextJ = arr[i][j] + j; // 오른쪽으로 점프

                if(nextI < n) dp[nextI][j] += dp[i][j];
                if(nextJ < n) dp[i][nextJ] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
        br.close();
    }
}