import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; //n 까지의 값을 저장하기 위한 배열

        //초기값
//        dp[1] = 1;
//        dp[2] = 2; // n=1일때 ArrayIndexOutOfBoundsException => 1) 던지거나 2) 배열을 new int[1001] 로 설정하거나
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}