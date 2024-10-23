import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);

        double sum1 = 0;
        for (int i = 1; i < s.length(); i++) {
            sum1 += i * 9 * Math.pow(10, i - 1);
        }

        double sum2 = 0;
        sum2 = s.length() * (n - Math.pow(10, s.length() - 1) + 1); // 마지막 자리수 계산

        System.out.println((int) (sum1 + sum2));

    }
}