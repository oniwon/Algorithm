import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) { // 체스판 입력 받기
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                // 'B'로 시작할 때와 'W'로 시작할 때 중 더 적게 칠해야 하는 경우
                result = Math.min(result, Math.min(count(i, j, 'B'), count(i, j, 'W')));
            }
        }
        System.out.println(result);
    }

    public static int count(int a, int b, char startColor) {
        int countNum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColor = 'B'; // 예상 색상 초기화
                if((i + j) % 2 == 0) { // i, j 합이 짝수 칸일때
                    expectedColor = startColor; // 시작 색상과 같아야 함
                } else { // i, j 합이 홀수 칸일때
                    if(startColor == 'B') expectedColor = 'W';
                    else if(startColor == 'W') expectedColor = 'B';
                }

                if(board[a + i][b + j] != expectedColor) countNum++;
            }
        }
        return countNum;
    }
}