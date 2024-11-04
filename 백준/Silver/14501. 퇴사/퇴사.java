import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] schedule;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        schedule = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // Ti
            schedule[i][1] = Integer.parseInt(st.nextToken()); // Pi
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int day, int pay) {
        if (day >= n) { // 재귀 탈출 조건
            answer = Math.max(answer, pay);
            return;
        }

        // 현재 상담을 선택하는 경우
        if (day + schedule[day][0] <= n) { // 상담을 완료할 수 있는 경우에만
            dfs(day + schedule[day][0], pay + schedule[day][1]);
        }

        // 현재 상담을 건너뛰는 경우(0부터 가능한 경우 다 훑기)
        dfs(day + 1, pay);
    }
}
