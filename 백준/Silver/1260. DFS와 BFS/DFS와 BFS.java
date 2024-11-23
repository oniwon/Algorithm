import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int v;
    static  List<List<Integer>> list; // 인접 리스트
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        sb = new StringBuilder();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i <= n; i++) {
            Collections.sort(list.get(i)); // 정점 번호가 작은 것 먼저 방문
        }

        dfs(v);
        sb.append("\n");

        Arrays.fill(visited, false);

        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for(int num : list.get(node)) {
            if(!visited[num]) {
                dfs(num);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        sb.append(node).append(" ");  // 시작 노드 추가

        while (!queue.isEmpty()) {
            int front = queue.poll();

            for (int i : list.get(front)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}