import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 최대공약수 구하기
            int GCD = gcd(A, B);

            // 최소공배수 구하기
            int LCM = (A * B) / GCD; // 두 수를 곱하고 최대공약수로 나눈 값

            sb.append(LCM).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a; // b 가 0 일때 a 가 최대공약수
        return gcd(b, a%b); // b 를 a 를 b 로 나눈 나머지로 나누기
    }
}