import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int[][] stickers = new int[2][n]; // 스티커 점수 배열

        int[] drinks = new int[n + 1];
        int[] dp = new int[n + 1]; // i번째 포도주를 마실 때의 최댓값 저장할 배열

        for(int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }

        // 초기값
        dp[1] = drinks[1];
        if(n > 1) { //
            dp[2] = drinks[1] + drinks[2];
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // i번째 포도주를 마시지 않는 경우
                    Math.max(
                            dp[i - 2] + drinks[i], // i번째 포도주를 마시고 i-1번째 잔은 건너뛰는 경우
                            dp[i - 3] + drinks[i - 1] + drinks[i] // i-1번째와 i번째 포도주를 마시고 i-2번째 잔은 건너뛰는 경우
                    )
            );
        }
        System.out.println(dp[n]);
    }
}