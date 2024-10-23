import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = lcm(M, N); // M과 N의 최소공배수 계산

            boolean found = false;
            for (int k = x; k <= lcm; k += M) { // x부터 최소공배수까지 M씩 증가시키면서(x에서 시작해서 M씩 더한 값들이 k % M == x를 만족시킴) y값 확인
                if ((k - 1) % N + 1 == y) { // y가 맞으면 출력
                    System.out.println(k);
                    found = true;
                    break;
                }
            }

            if (!found) { // 못 찾은 경우
                System.out.println(-1);
            }
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) { // b 가 0 일때 a 가 최대공약수
            return a;
        }
        return gcd(b, a%b); // b 를 a 를 b 로 나눈 나머지로 나누기
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
