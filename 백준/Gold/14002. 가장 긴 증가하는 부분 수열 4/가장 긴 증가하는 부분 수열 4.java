import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n]; // 입력값 저장할 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n]; // LIS 길이를 저장할 배열
        dp[0] = 1; // 첫 번째 원소는 항상 길이가 1
        int lis = 1; // 가장 긴 증가하는 부분 수열의 길이

        // LIS 길이 계산
        for (int i = 1; i < n; i++) {
            dp[i] = 1; // 자기 자신으로 초기화
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp 배열 추가
                }
            }
            lis = Math.max(lis, dp[i]); // 가장 긴 LIS 길이 갱신
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis).append("\n"); // LIS 길이 출력

        // Stack을 이용하여 LIS를 역추적
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lis) { // dp[i]가 가장 긴 LIS 길이였을 때
                s.push(arr[i]); // arr[i] 값을 Stack에 추가
                lis--;
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop()).append(" ");
        }
        System.out.println(sb);
    }
}