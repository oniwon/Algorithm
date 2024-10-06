import java.io.*;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; // dp[i] 값(최소 연산 횟수)을 저장하기 위한 배열

        dp[1] = 0; // 1은 이미 1이므로 0으로 초기화
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1; // i-1 이 가능한 경우, 연산 횟수 1 추가
            if(i%2 == 0) dp[i] = min(dp[i], dp[i/2] + 1); // 나누기 2가 가능한 경우, 이와 비교해서 최소 연산 횟수 선택
            if(i%3 == 0) dp[i] = min(dp[i], dp[i/3] + 1); // 나누기 3이 가능한 경우, 이와 비교해서 최소 연산 횟수 선택
        }
        System.out.println(dp[n]);
    }
}
