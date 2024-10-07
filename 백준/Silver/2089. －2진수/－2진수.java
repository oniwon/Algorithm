import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % -2; // -2로 나눈 나머지
            n = n / -2; // -2로 나눈 몫

            // 나머지가 음수일 경우 몫+1, 나머지+2 해줌
            if(remainder < 0) {
                remainder += 2;
                n += 1;
            }
            sb.append(remainder);
        }

        // 나머지를 역순으로 출력
        System.out.println(sb.reverse());
    }
}