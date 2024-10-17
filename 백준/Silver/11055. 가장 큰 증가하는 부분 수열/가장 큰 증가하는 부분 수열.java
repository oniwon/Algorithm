import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1]; // 수열 저장할 배열
        int[] dp = new int[n + 1];  // 각 원소까지의 최대 합 저장

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0; // 최대값을 저장할 변수

        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i]; // 자기 자신의 값으로 초기화
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) { // j의 값이 i보다 작을 때
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]); // max 업데이트
        }

        System.out.println(max);
    }
}