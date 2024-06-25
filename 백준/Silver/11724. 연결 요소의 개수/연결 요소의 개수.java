import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) { // 리스트 초기화
            list.add(new ArrayList<>());
        }

        visited = new boolean[n + 1]; // 1부터 시작

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++; // 호출한 개수 = 연결 요소 개수
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int i : list.get(node)) {
            if(!visited[i]) dfs(i); // i 방문 안 했을때만 호출
        }
    }
}