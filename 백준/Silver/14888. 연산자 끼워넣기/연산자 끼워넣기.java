import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr; // 숫자 배열
    static int[] cal; // 연산자 배열
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cal = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) { // 숫자 입력 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) { // 연산자 개수 입력 받기
            cal[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1); // 첫 번째 숫자로 시작
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int result, int depth) {
        if (depth == n) { // 재귀 탈출 조건
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) { // 사용할 수 있는 연산자가 남아있다면
                cal[i]--; // 연산자 사용
                int newResult = calculate(result, arr[depth], i); // 현재 결과값에 다음 숫자와 연산
                dfs(newResult, depth + 1); // 다음 깊이 탐색
                cal[i]++; // 연산자 복원
            }
        }
    }

    public static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0: return a + b; // 덧셈
            case 1: return a - b; // 뺄셈
            case 2: return a * b; // 곱셈
            case 3: return a / b; // 나눗셈
            default: return 0;
        }
    }
}
