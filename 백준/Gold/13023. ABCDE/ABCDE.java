import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list;
    static boolean[] visited;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 노드
        int m = Integer.parseInt(st.nextToken()); // 간선

        list = new ArrayList<>(); // 인접 리스트
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[n];
        found = false;

        // 모든 노드에서 DFS 탐색
        for (int i = 0; i < n; i++) {
            if (!found) {
                dfs(i, 1);
            }
        }

        System.out.println(found ? 1 : 0);
    }

    public static void dfs(int node, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;
        for (int friend : list.get(node)) {
            if (!visited[friend]) {
                dfs(friend, depth + 1);
                if (found) return;
            }
        }
        visited[node] = false; // 방문 해제
    }
}