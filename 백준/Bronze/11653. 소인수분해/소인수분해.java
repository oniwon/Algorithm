import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i * i <= n; i++) { // n의 제곱근 이하일 때까지 반복(인수 중 하나가 n의 제곱근 이하이므로)
            while (n % i == 0) {
                System.out.println(i);
                n /= i; // n을 소인수 i로 나누기
            }
        }

        // 남은 n이 소수일 경우 출력해주기
        if (n > 1) {
            System.out.println(n);
        }
    }
}