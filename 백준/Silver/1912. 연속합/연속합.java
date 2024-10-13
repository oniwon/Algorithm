import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력값 담을 배열
        int[] dp = new int[n]; // i 번째까지의 연속합의 최대값

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0]; // 초기값

        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]); // 현재 숫자를 선택하는 경우와 이전 연속합의 최대값에 현재 숫자를 더하는 경우

            max = Math.max(dp[i], max); // dp 배열에서 최대값 갱신
        }
        System.out.println(max);
    }
}