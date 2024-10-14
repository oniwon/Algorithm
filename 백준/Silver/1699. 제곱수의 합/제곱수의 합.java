import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[0] = 0; // 초기값
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = i; // i를 1의 제곱수만으로 표현하는 경우로 초기화(최대 개수로 초기화)
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // n에서 가장 가까운 제곱수를 뺀 dp값 + 1
            }
        }
        System.out.println(dp[n]);
    }
}