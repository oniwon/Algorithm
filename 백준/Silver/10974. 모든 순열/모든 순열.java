import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n]; // 출력 담을 배열
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int d) {
        if(d == n) {
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[d] = i + 1;
            dfs(d + 1); // 다음 깊이로 재귀 호출
            visited[i] = false;
        }
    }
}