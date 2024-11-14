import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int b = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수
        int c = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자 수

        long result = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - b;
            result++; // 총감독관 한명 추가

            // 부감독관 추가
            if (arr[i] > 0) {
                result += arr[i] / c;

                if(arr[i] % c != 0) result++;
            }
        }

        System.out.println(result);
    }
}