import java.io.*;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; //n 까지의 값을 저장하기 위한 배열

        dp[1] = 0; //초기값
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1; //-1 가능할 경우 dp[i] 값 갱신
            if(i%2 == 0) dp[i] = min(dp[i], dp[i/2] + 1); //2로 나누기 가능할 경우
            if(i%3 == 0) dp[i] = min(dp[i], dp[i/3] + 1); //3으로 나누기 가능할 경우
        }
        System.out.println(dp[n]);
    }
}