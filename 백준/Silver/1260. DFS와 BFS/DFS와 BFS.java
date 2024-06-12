import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> list; // 인접 리스트에 그래프 담기
    private static boolean[] visited;  // 방문 노드 체크할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        list = new ArrayList<>();

        for(int i = 0; i <= n; i++) { // 1부터 정점 개수만큼 list 초기화
            list.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) { // list 에 값 담기
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        for(int i = 0; i <= n; i++) {
            Collections.sort(list.get(i)); // 정점 번호가 작은 것을 먼저 방문=> 인접 리스트 정렬
        }

        dfs(v);
        System.out.println();

        visited = new boolean[n + 1]; // 방문 배열 초기화

        bfs(v);
    }


    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int i : list.get(node)) {
            if(!visited[i]) dfs(i);
        }
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front + " ");

            for (int i : list.get(front)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}