import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[] arr; // 입력 저장할 배열
    public static int[] p; // 출력 담을 배열
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        p = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int d, int s) {
        if(d == m) {
            for(int i : p) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = s; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            p[d] = arr[i]; // 현재 깊이 d에서 arr[i] 값 넣기
            dfs(d + 1, i + 1); // 다음 깊이로 재귀 호출, i+1 인덱스부터 선택해사 오름차순 되도록
            visited[i] = false;
        }
    }
}