import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list; // 인접 리스트
    static boolean[] visited;
    static int[] answer; // 주어진 DFS 방문 순서
    static int index = 2; // answer[] 탐색 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        answer = new int[n + 1];

        // 인접 리스트 초기화
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 인접 리스트 저장
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // index 1부터 DFS 방문 순서 저장
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        if(answer[1] != 1) { // DFS 첫 번째 노드는 항상 1
            System.out.println("0");
            return;
        }

        System.out.println(dfs(1) ? "1" : "0");
    }

    public static boolean dfs(int node) {
        visited[node] = true;

        Set<Integer> possibleNext = new HashSet<>();
        for (int next : list.get(node)) {
            if (!visited[next]) {
                possibleNext.add(next);
            }
        }

        for (int i = 0; i < possibleNext.size(); i++) {
            if (index >= answer.length || !possibleNext.contains(answer[index])) {
                return false;
            }
            int next = answer[index++];
            if (!dfs(next)) {
                return false;
            }
        }

        return true;
    }
}