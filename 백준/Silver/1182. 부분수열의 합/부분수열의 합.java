import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int s;
    static int answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 정수 개수
        s = Integer.parseInt(st.nextToken()); // 목표 합
        answer = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if(s == 0) answer--; // 공집합 제외
        System.out.println(answer);

        br.close();
    }

    public static void dfs(int depth, int sum) {
        if(depth == n) {
            if(sum == s) answer++;
            return;
        }

        dfs(depth + 1, sum + arr[depth]); // 현재 원소를 포함하는 경우
        dfs(depth + 1, sum); // 현재 원소를 포함하지 않는 경우
    }
}