import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine(), 8); // 8진수를 10진수로 변환

        String answer = n.toString(2); // String 으로 형변환할 때 2진수로 바꾸기

        System.out.println(answer);
    }
}
