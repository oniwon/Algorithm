import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) { // 1은 소수가 아님
                continue;
            }

            int j;
            for (j = 2; j <= Math.sqrt(num); j++) { // 2부터 제곱근까지 나누기
                if (num % j == 0) { // 나누어 떨어지는 경우
                    break; // 소수가 아님
                }
            }

            if (j > Math.sqrt(num)) { // 끝까지 나누어 떨어지지 않는 경우
                count++; // 소수 개수 증가
            }
        }

        System.out.println(count);
    }
}
