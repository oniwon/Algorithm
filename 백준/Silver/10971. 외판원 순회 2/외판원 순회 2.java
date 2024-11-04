import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] W;
    public static boolean[] visited;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        W = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) { // 배열 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 첫번째 도시부터 시작
        visited[0] = true;
        dfs(0, 0, 1, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int now, int count, int cost) {
        if(count == n) {
            if(W[now][start] != 0) { // 시작 도시로 돌아갈 수 있는 경우
                answer = Math.min(answer, cost + W[now][start]);
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i] && W[now][i] != 0) { // 아직 방문하지 않았고 다음 도시로 갈 수 있는 경우
                visited[i] = true;
                dfs(start, i, count + 1, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }
}