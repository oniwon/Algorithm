import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        if (n < 100) {
            count = n; // 1~99까지 모두 한수
        } else {
            count = 99;
            for (int i = 100; i <= n; i++) {
                int a = i / 100; // 백의 자리
                int b = (i / 10) % 10; // 십의 자리
                int c = i % 10; // 일의 자리

                if ((a - b) == (b - c)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}