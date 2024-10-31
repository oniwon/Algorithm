import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] arr; // 입력 저장할 배열
    public static int[] p; // 출력 담을 배열
    public static boolean[] visited; // 방문 체크 배열
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        p = new int[n];
        visited = new boolean[n];
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int d) {
        if(d == n) {
            int sum = 0;
            for(int i = 0; i < n - 1; i++) {
                sum += Math.abs(p[i] - p[i + 1]);
            }
            answer = Math.max(sum, answer); // 합의 절대값의 최대값 구하기
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            p[d] = arr[i]; // 현재 깊이 d에서 arr[i] 값 저장
            dfs(d + 1); // 다음 깊이로 재귀 호출
            visited[i] = false;
        }
    }
}