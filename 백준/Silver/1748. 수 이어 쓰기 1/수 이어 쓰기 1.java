import java.io.*;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int length = s.length(); // n 의 자릿수

        int n = Integer.parseInt(s);


        double sum1 = 0, sum2 = 0;
        for(int i = 1; i < length; i++) {
            sum1 += i * (9 * pow(10, i-1));
        }

        sum2 = length * (n - pow(10, length-1) + 1); // 마지막 자릿수

        int result = (int) (sum1 + sum2);
        
        System.out.println(result);
        
    }
}