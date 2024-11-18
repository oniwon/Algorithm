import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];

        // 직사각형 영역 1로 채우기
        for(int t = 0; t < k; t++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            int d = Integer.parseInt(str[3]);

            for(int i = b; i < d; i++) {
                for(int j = a; j < c; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        int space = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] != 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    list.add(size);
                    space++; // 영역 개수 증가
                }
            }
        }
        System.out.println(space);
        Collections.sort(list);
        for(int num : list) {
            System.out.print(num + " ");
        }
    }

    public static int dfs(int r, int c) {
        visited[r][c] = true;

        int count = 1; // 현재 영역 크기 1로 초기화
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if(arr[nr][nc] != 1 && !visited[nr][nc]) {
                    count += dfs(nr, nc); // 영역 크기 더해주기
                }
            }
        }
        return count;
    }
}