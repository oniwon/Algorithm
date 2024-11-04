import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static int[] arr; // 입력 저장할 배열
    public static int[] p = new int[6]; // 출력 담을 배열
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());

            if (k == 0) { // 입력이 0이면 종료
                break;
            }

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int d, int s) {
        if (d == 6) { // 탈출 조건
            for (int i : p) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = s; i < k; i++) {
            p[d] = arr[i]; // 현재 깊이 d에 arr[i] 값 넣기
            dfs(d + 1, i + 1); // 다음 깊이로 재귀 호출, i+1 인덱스부터 선택해서 오름차순 되도록
        }
    }
}