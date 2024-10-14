import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3]; // 각 집의 비용을 저장할 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            arr[i][1] = Integer.parseInt(st.nextToken()); // 초록
            arr[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }

        for (int i = 1; i < n; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]); // 현재 집을 빨강으로 칠할 경우
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]); // 현재 집을 초록으로 칠할 경우
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]); // 현재 집을 파랑으로 칠할 경우
        }

        int answer = Math.min(Math.min(arr[n - 1][0], arr[n - 1][1]), arr[n - 1][2]); // 최소 비용 출력
        System.out.println(answer);
    }
}
