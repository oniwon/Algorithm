import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String N = input[0]; // B진법 수 N

        int B = Integer.parseInt(input[1]); // B진법

        BigInteger answer = new BigInteger(N, B); // N을 B진법에서 10진법으로 변환
        System.out.println(answer);
    }
}
