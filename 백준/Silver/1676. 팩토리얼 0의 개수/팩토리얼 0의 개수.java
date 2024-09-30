import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        // 10이 몇 번 곱해졌는지 세기 (n!에서 2의 개수가 5보다 많기 때문에 5의 개수 세기)
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }
}
