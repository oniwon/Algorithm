import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = factorial(n);
        System.out.println(answer);
    }

    private static int factorial(int n) {
        if(n <= 1) return 1; // n 이 1일 때 종료
        return n * factorial(n - 1); // 재귀 사용
    }
}
