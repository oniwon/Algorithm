import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] arr;
    static int n;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j);
                    answer.add(count);
                }
            }
        }
        System.out.println(answer.size()); // 단지 수
        Collections.sort(answer);
        for(int i : answer) System.out.println(i); // 각 단지 수 출력(오름차순)
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nc = x + dc[i];
            int nr = y + dr[i];

            if (nc >= 0 && nc < n && nr >= 0 && nr < n) {
                if (arr[nc][nr] == 1 && !visited[nc][nr]) {
                    count += dfs(nc, nr);
                }
            }
        }
        return count;
    }
}