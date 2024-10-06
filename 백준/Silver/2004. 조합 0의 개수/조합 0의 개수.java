import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        // nCm = n! / (n-m)!m!
        int two = findTwo(n) - findTwo(n - m) - findTwo(m);
        int five = findFive(n) - findFive(n - m) - findFive(m);

        // 0의 개수 구하기 => 2와 5 중 더 작은 개수 선택
        System.out.println(Math.min(two, five));
    }

    // 2의 개수 구하기
    public static int findTwo(int num) {
        int TwoCount = 0;
        while (num >= 2) {
            TwoCount += num / 2;
            num /= 2;
        }
        return TwoCount;
    }

    // 5의 개수 구하기
    public static int findFive(int num) {
        int fiveCount = 0;
        while (num >= 5) {
            fiveCount += num / 5;
            num /= 5;
        }
        return fiveCount;
    }
}
