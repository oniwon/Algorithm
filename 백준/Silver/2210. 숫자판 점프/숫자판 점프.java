import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> set; // 6자리 숫자를 저장할 Set
    static int[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, ""); // 숫자는 빈 문자열로 시작
            }
        }
        System.out.println(set.size());
    }

    public static void dfs(int r, int c, int depth, String number) {
        if (depth == 6) { // 6자리가 완성되면 Set에 추가
            set.add(number);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                dfs(nr, nc, depth + 1, number + board[nr][nc]);
            }
        }
    }
}
