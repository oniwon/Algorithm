import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> list; // 인접 리스트

    private static boolean[] visited;

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }


        count = 0;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int i : list.get(node)) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
