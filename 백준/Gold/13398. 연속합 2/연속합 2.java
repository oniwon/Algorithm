import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력값 담을 배열
        int[] dp1 = new int[n]; // 수를 제거하지 않은 연속합의 최대값 담을 배열
        int[] dp2 = new int[n]; // 수를 하나 제거한 연속합의 최대값 담을 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = arr[0]; // 초기값
        dp2[0] = 0;      // 첫 번째 수 제거 못함 => 0으로 초기화

        int max = dp1[0];
        for (int i = 1; i < n; i++) {
            // 수를 제거하지 않은 경우
            dp1[i] = Math.max(arr[i], dp1[i - 1] + arr[i]); // 현재 숫자를 선택하는 경우, 이전 연속합의 최대값에 현재 숫자를 더하는 경우

            // 수를 제거한 경우
            dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + arr[i]); // 현재 수 제거한 경우, 이전에 제거해서 현재 수를 더하는 경우

            max = Math.max(max, Math.max(dp1[i], dp2[i])); // 최대값 갱신
        }

        System.out.println(max);
    }
}