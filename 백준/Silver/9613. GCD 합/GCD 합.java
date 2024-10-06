import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 각 테스트 케이스는 수의 개수

            int[] numbers = new int[n]; // 배열에 입력받은 숫자들 넣기
            for(int j = 0; j < n; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            for(int k = 0; k < n - 1; k++) {
                for(int l = k + 1; l < n; l++) {
                    answer += gcd(numbers[k], numbers[l]); // 배열 안의 숫자의 gcd 합 구하기
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a; // b 가 0 일때 a 가 최대공약수
        return gcd(b, a % b); // b 를 a 를 b 로 나눈 나머지로 나누기
    }
}
