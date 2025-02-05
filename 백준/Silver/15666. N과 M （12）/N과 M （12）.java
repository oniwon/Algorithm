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
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        p = new int[m];

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

        int prev = 0; // 이전 값 기억
        for(int i = s; i < n; i++) {
            if(arr[i] == prev) continue; // 이전과 같은 값이면 스킵
            p[d] = arr[i]; // 현재 깊이 d에 arr[i] 값 넣기
            prev = arr[i]; // 현재 값을 prev에 저장
            dfs(d + 1, i); // 다음 깊이로 재귀 호출, 시작 인덱스를 i로 해서 오름차순 유지
        }
    }
}