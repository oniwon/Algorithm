import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static boolean[][] visited;
    private static ArrayList<Integer> countList; // 단지별 개수 담을 배열
    private static int n ,count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];
        countList = new ArrayList<>();

        count = 1; // 현재 집 위치 개수

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if(arr[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);
                    countList.add(count);
                    count = 1; // 단지별 집 개수 다시 1로 초기화
                }
            }
        }

        Collections.sort(countList);
        System.out.println(countList.size());
        for(int i : countList) {
            System.out.println(i);
        }

    }

    private static void dfs(int x, int y) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && arr[nr][nc] == 1 && !visited[nr][nc]) {
                count++;
                dfs(nr, nc);
            }
        }
    }
}