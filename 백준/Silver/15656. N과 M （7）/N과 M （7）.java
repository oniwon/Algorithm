import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m; // 깊이

    public static int[] arr;
    public static int[] p; // 출력 담을 배열

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        p = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        if (d == m) {    // 깊이 같을 때 출력
            for (int i : p) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            p[d] = arr[i];
            dfs(d + 1);
        }
    }
}