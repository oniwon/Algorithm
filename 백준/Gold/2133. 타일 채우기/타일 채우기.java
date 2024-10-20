import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if (n % 2 == 1) {  // n이 홀수일 경우
            System.out.println(0); // 0 출력
            return;
        }

        dp[0] = 1; // 초기값

        for (int i = 2; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3; // 끝에 dp[2]를 붙이는 경우: 3종류씩 곱하기
            for (int j = i - 4; j >= 0; j -= 2) { // 이전의 짝수 길이에 대해서 2씩 줄여가면서 예외 경우의 수 추가
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}