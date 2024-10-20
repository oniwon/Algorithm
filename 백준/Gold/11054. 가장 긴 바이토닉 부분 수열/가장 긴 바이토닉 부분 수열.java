import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력받을 수열 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 입력받은 수열 담기
        }

        int[] dp1 = new int[n]; // 가장 긴 증가하는 부분수열의 길이 저장할 배열
        for (int i = 0; i < n; i++) { // 오른쪽부터 시작
            dp1[i] = 1; // 자기자신의 부분수열(1개)로 초기화
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        int[] dp2 = new int[n]; // 가장 긴 감소하는 부분수열의 길이 저장할 배열
        for (int i = n - 1; i >= 0; i--) { // 왼쪽부터 시작
            dp2[i] = 1; // 자기자신의 부분수열(1개)로 초기화
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp1[i] + dp2[i]); // dp1[i] + dp2[i]가 최대인 값 찾기
        }
         System.out.println(max - 1); // 중복된 값 빼기
    }
}