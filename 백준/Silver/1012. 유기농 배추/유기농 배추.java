import java.io.*;
import java.util.*;

public class Main {

    private static int[][] field;
    private static int m;
    private static int n;
    private static boolean[][] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[m][n];
            visited = new boolean[m][n];
            answer = 0;

            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st2.nextToken());
                int o = Integer.parseInt(st2.nextToken());
                field[l][o] = 1;
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (field[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        answer++; // 호출하다가 더 이상 호출할 데가 없으면 answer++
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(int x, int y) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nr = x + dr[k];
            int nc = y + dc[k];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && field[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
