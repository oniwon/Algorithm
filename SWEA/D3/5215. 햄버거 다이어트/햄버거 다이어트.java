import java.io.*;
import java.util.*;

public class Solution {

    static int n;
    static int l;
    static int answer;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            arr = new int[n][2];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                    arr[i][0] = Integer.parseInt(st.nextToken()); // 맛 점수
                    arr[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            answer = Integer.MIN_VALUE;
            dfs(0, 0, 0);
            sb.append("#").append(t + 1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int score, int calorie) {
        // 재귀 탈출 조건
        if(depth == n) {
            if(calorie <= l) { // 칼로리 제한 이하일 때
                answer = Math.max(answer, score);
            }
            return;
        }

        if(calorie + arr[depth][1] <= l) {
            dfs(depth + 1, score + arr[depth][0], calorie + arr[depth][1]); // 해당 햄버거를 선택할 경우
        }

        dfs(depth + 1, score, calorie); // 해당 햄버거를 선택하지 않는 경우
    }
}