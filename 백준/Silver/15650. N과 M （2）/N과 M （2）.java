import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n; // 1부터 n 까지
    public static int m; // 깊이
    public static int arr[]; // 출력 담을 배열
    public static boolean v[]; // 방문한 노드 체크할 배열
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        v = new boolean[n];

        dfs(0,0);
        System.out.println(sb);
    }

    private static void dfs(int s, int d) {
        if(d == m) { // 재귀 탈출 조건
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = s; i < n; i++) {
            if(v[i]) continue; // true (이미 노드 방문했을시 넘어가기)
            v[i] = true; // 방문한 노드 true 로 바꿔주기
            arr[d] = i + 1; // 깊이마다 1씩 더해서 출력하도록
            dfs(i + 1, d + 1); // 자식 노드 방문, s+1부터 arr 채워지도록
            v[i] = false; // 방문 상태 되돌리기
        }

    }
}