import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        BigInteger N = new BigInteger(input[0]); // 10진수 N

        int B = Integer.parseInt(input[1]); // B진법

        String answer = N.toString(B).toUpperCase(); // B진법으로 변환
        System.out.println(answer);
    }
}
