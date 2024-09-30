import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean[] isPrime = new boolean[1000001]; // 소수 여부 저장할 배열
        sieveOfEratosthenes(isPrime); // 에라토스테네스의 체로 소수 계산

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            boolean found = false;

            for (int a = 3; a < n; a++) { // a는 3부터 시작
                if (isPrime[a] && isPrime[n - a]) { // a와 n-a가 모두 소수이면
                    System.out.println(n + " = " + a + " + " + (n - a)); // 출력
                    found = true;
                    break;
                }
            }

            if (!found) { // 소수 쌍을 못 찾았을 때
                System.out.println("Goldbach's conjecture is wrong.");
            }
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

// n = a + b
// 8 = 3 + 5