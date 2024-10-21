import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] board;
    public static int n;
    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 가로로 인접한 사탕 교환
                swap(board, i, j, i, j + 1);
                max = Math.max(max, search()); // 최대 개수 찾기
                swap(board, i, j, i, j + 1); // 원래대로 되돌리기

                // 세로로 인접한 사탕 교환
                swap(board, j, i, j + 1, i);
                max = Math.max(max, search()); // 최대 개수 찾기
                swap(board, j, i, j + 1, i); // 원래대로 되돌리기
            }
        }
        System.out.println(max);
    }


    // 사탕 교환
    private static void swap(char[][] board, int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    // 최대 연속된 사탕 개수 찾기
    private static int search() {
        int max = 0;
        // 가로
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) { // 양옆 같을 경우
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) { // 위아래 같을 경우
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}