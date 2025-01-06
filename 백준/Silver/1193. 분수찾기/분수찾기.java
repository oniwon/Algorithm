import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int floor = 1;
        while (n - floor > 0) {
            n -= floor;
            floor++;
        }

        int a = 0; int b = 0; // 분모, 분자
        int sum = floor + 1; // 층수 합


        if(floor%2==1) {
            a = n;
            b = sum - n;
        }

        if(floor%2==0) {
            b = n;
            a = sum - n;
        }

        System.out.println(b+ "/" + a);
    }
}
