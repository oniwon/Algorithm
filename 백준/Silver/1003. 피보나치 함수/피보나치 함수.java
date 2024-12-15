import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        // 0과 1 호출 횟수 저장
        int[] countZero = new int[41];
        int[] countOne = new int[41];

        countZero[0] = 1;
        countOne[0] = 0;
        countZero[1] = 0;
        countOne[1] = 1;

        for (int i = 2; i <= 40; i++) {
            countZero[i] = countZero[i - 1] + countZero[i - 2];
            countOne[i] = countOne[i - 1] + countOne[i - 2];
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(countZero[n]).append(" ").append(countOne[n]).append("\n");
        }

        System.out.print(sb);
    }
}