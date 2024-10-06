import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동생 수
        int s = Integer.parseInt(st.nextToken()); // 수빈 위치

        int[] points = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st2.nextToken());
            points[i] = Math.abs(s - points[i]); // 수빈 위치와 동생 위치 차이의 절대값
        }

        int answer = points[0];  // 첫 번째 차이로 초기화
        for(int i = 1; i < n; i++) {
            answer = gcd(answer, points[i]); // 현재까지 구한 GCD 와 points[i]의 GCD 계산
        }
        System.out.println(answer);
    }

    // D를 구하기 위해 GCD 를 구해야 함
    public static int gcd(int a, int b) {
        if(b == 0) return a; // b 가 0 일때 a 가 최대공약수
        return gcd(b, a % b); // b 를 a 를 b 로 나눈 나머지로 나누기
    }
}
