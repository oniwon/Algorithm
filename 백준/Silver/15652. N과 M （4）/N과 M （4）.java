import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m; // 깊이
    public static int[] arr; // 출력 담을 배열
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());

       arr = new int[m];

       dfs(0, 0);
       System.out.println(sb);
    }

    private static void dfs(int s, int d) {
        if(d == m) {    // 깊이 같을 때 출력
            for(int i : arr) {
                sb.append(i).append(" ");
            } sb.append("\n");
            return;
        }

        for(int i = s; i < n; i++) {
            arr[d] = i + 1;
            dfs(i, d + 1); // arr 에 s 부터 담기
        }
    }
}