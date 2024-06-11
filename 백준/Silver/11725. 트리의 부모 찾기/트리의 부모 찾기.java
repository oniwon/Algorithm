import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> list; // 그래프 담을 인접리스트
    private static boolean v[]; // 방문 노드 체크할 배열
    private static int[] parents; // 부모 노드 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        v = new boolean[n + 1]; // 노드 번호 1부터 시작
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>()); // 각 노드 리스트 초기화
        }

        StringTokenizer st = null;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); // 노드 a의 인접 리스트에 노드 b 추가
            list.get(b).add(a); // 노드 b의 인접 리스트에 노드 a 추가
        }

        dfs(1);

        for (int i = 2; i <= n; i++) { // 2번 노드부터 출력
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int node) {
        v[node] = true;
        for(int n : list.get(node)) {
            if(!v[n]) {
                parents[n] = node; // 현재 노드가 부모 노드
                dfs(n); // 방문 안 했으면 호출
            }
        }
    }
}