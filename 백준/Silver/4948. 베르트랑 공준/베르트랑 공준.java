import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 123456 * 2; // 문제 제한 범위

        boolean[] isPrime = sieveOfEratosthenes(MAX);

        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i] == false) { // 소수인 경우
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];

        // 0과 1은 소수가 아님
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == true) { // 이미 소수가 아닐 때
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                prime[j] = true; // i의 배수는 소수가 아님
            }
        }
        return prime;
    }
}