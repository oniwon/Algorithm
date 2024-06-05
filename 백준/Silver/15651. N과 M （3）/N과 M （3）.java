import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n; // 1부터 n 까지
    public static int m; // 깊이
    public static int arr[]; // 출력 담을 배열
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        if(d == m) { // 재귀 탈출 조건
            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[d] = i + 1; // 깊이마다 1씩 더해서 출력하도록
            dfs(d + 1); // 자식 노드 방문
        }
    }
}