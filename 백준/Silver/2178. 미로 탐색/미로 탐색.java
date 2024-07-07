import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int n, m;
    private static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));

    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int r = front[0];
            int c = front[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    arr[nr][nc] = arr[r][c] + 1; // 현재 위치까지의 거리 + 1
                }
            }
        }

        return arr[n-1][m-1];
    }
}