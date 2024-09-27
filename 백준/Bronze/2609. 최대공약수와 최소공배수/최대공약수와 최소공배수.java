import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int GCD = gcd(A, B);
        int LCM = (A * B) / GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }

    public static int gcd(int a, int b) {
        if(b == 0) { // b 가 0 일때 a 가 최대공약수
            return a;
        }
        return gcd(b, a%b); // b 를 a 를 b 로 나눈 나머지로 나누기
    }
}