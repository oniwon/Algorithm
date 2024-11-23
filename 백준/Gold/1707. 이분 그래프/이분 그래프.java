import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v;
    static int e;
    static List<List<Integer>> list; // 인접 리스트

    static int[] colors;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            colors = new int[v + 1]; // 0(미방문), 1, -1
            answer = true;

            for(int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(int i = 0; i <= v; i++) {
                if(colors[i] == 0) {
                    if(!bfs(i)) { // bfs 가 false 이면 종료
                        answer = false;
                        break;
                    }
                }
            }

            if (answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    public static boolean bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1; // 시작 노드: 1

        while (!queue.isEmpty()) {
            int front = queue.poll();

            for(int i : list.get(front)) {
                if(colors[front] == colors[i]) { // 인접 노드가 같은 색이라면
                    return false;
                }

                if(colors[i] == 0) {
                    colors[i] = -colors[front]; // 반대색으로 칠하기
                    queue.add(i);
                }
            }
        }
        return true;
    }
}
