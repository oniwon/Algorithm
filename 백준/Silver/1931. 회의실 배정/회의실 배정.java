import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬
            } else {
                return a[1] - b[1]; // 종료 시간이 빠른 순으로 정렬
            }
        });

        int count = 0;
        int EndTime = 0;
        for (int i = 0; i < n; i++) {
            if (time[i][0] >= EndTime) { // 회의 시작 시간이 마지막 회의 종료 시간 이후면
                count++;
                EndTime = time[i][1];
            }
        }

        System.out.println(count);
    }
}