import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[1000001]; // 소수 여부 저장할 배열
        sieveOfEratosthenes(isPrime); // 에라토스테네스의 체로 소수 계산

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int count = 0;
            for (int a = 2; a <= n / 2; a++) { // 두 소수의 순서만 다른 것은 같은 파티션이므로 n / 2 까지
                if (isPrime[a] && isPrime[n - a]) { // a와 n-a가 모두 소수이면
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    // 에라토스테네스의 체 이용
    public static void sieveOfEratosthenes(boolean[] isPrime) {
        int limit = isPrime.length - 1;

        for (int i = 2; i <= limit; i++) { // 모든 수를 소수로 가정
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) { // 소수 판별
            if (isPrime[i]) { // 소수일 때
                for (int j = i * i; j <= limit; j += i) { // i의 배수를 모두 false로 설정
                    isPrime[j] = false; // 소수 아님
                }
            }
        }
    }
}