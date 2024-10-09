import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; // 카드 n개를 갖기 위해 지불해야 하는 최대 금액을 저장할 배열
        int[] card = new int[n + 1]; // 카드팩의 가격 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]); // j개의 카드팩을 더한 후 최대값 갱신
            }
        }
        System.out.println(dp[n]);
    }
}