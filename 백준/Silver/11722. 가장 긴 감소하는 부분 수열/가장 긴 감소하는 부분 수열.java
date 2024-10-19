import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n]; // 입력된 수열 담을 배열
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = 1; // 자기자신의 부분수열(1개)로 초기화
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) { // 자기자신의 값(arr[i])이 이전 배열의 값(arr[j])보다 작을 떄
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 최대값 갱신
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]); // dp 배열 중 최대값(가장 긴 감소하는 부분 수열의 길이) 출력
        }
        System.out.println(max);
    }
}