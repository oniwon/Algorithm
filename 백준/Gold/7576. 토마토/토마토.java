import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int[][] arr;
    static int[] dc = {-1, 0, 1, 0};
    static int[] dr = {0, 1, 0, -1};

    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 1) { // 1일 경우 queue 에 추가
                    queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int c = front[0];
            int r = front[1];

            for (int i = 0; i < 4; i++) {
                int nc = c + dc[i];
                int nr = r + dr[i];

                if (nc >= 0 && nc < n && nr >= 0 && nr < m && arr[nc][nr] == 0) {
                    queue.add(new int[]{nc, nr});
                    arr[nc][nr] = arr[c][r] + 1; // 날짜 증가
                }
            }
        }

        int count = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) return -1; // 토마토가 다 안 익었을 경우 -1
                count = Math.max(count, arr[i][j]); // 가장 오래 걸린 날짜
            }
        }

        if (count == 1) return 0; // 처음부터 모든 토마토가 익어있는 상태
        else return count - 1;
    }
}