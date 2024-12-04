import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> list; // 인접 리스트
    static boolean[] visited;
    static int[] answer; // 주어진 BFS 방문 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[n + 1];
        answer = new int[n + 1];

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

        // index 1부터 BFS 방문 순서 저장
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        if(answer[1] != 1) { // BFS 첫 번째 노드는 항상 1
            System.out.println("0");
            return;
        }

        bfs();
    }
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int start = 1;
        queue.add(start);
        visited[start] = true;

        int index = 2; // answer[] 을 index 2 부터 탐색

        while (!queue.isEmpty()) {
            int front = queue.poll();
            int count = 0; // 현재 노드의 자식 노드 수 저장

            for(int i : list.get(front)) {
                if(!visited[i]) {
                    visited[i] = true;
                    count++;
                }
            }

            for(int i = index; i < index + count; i++) {
                if(!visited[answer[i]]) { // 자식 노드를 방문하지 않았을 경우 순서 잘못됨
                    System.out.println("0");
                    return;
                } else queue.add(answer[i]);
            }

            index += count; // 다음 레벨의 시작 인덱스
        }
        System.out.println("1");
    }
}