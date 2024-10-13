import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력값 담을 배열
        int[] dp = new int[n]; // i번째까지의 LIS 길이를 저장하는 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 자기 자신의 길이로 초기화
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // dp 배열에서 가장 큰 값이 정답
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
/*
dp[3]
arr[0] < arr[3] 일때 dp[0]+1=2
arr[1] < arr[3] 일때 dp[1]+1=3으로 갱신
*/