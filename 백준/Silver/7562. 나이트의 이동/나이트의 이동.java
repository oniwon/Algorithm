import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2,};
    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int a, b, c, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(arr[c][d]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int c = front[0];
            int r = front[1];

            for (int i = 0; i < 8; i++) {
                int nc = c + dc[i];
                int nr = r + dr[i];

                if (nc >= 0 && nc < l && nr >= 0 && nr < l && !visited[nc][nr]) {
                    queue.add(new int[]{nc, nr});
                    visited[nc][nr] = true;
                    arr[nc][nr] = arr[c][r] + 1;
                }
            }
        }
    }
}