import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] chessBoard;
    static int[] KnightX = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] KnightY = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] QueenX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] QueenY = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chessBoard = new int[n][m];

        // Queen 위치 설정
        st = new StringTokenizer(br.readLine());
        int queenCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < queenCount; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            chessBoard[row][col] = 1;
        }

        // Knight 위치 설정
        st = new StringTokenizer(br.readLine());
        int knightCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knightCount; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            chessBoard[row][col] = 2;
        }

        // Pawn 위치 설정
        st = new StringTokenizer(br.readLine());
        int pawnCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pawnCount; i++) {
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            chessBoard[row][col] = 3;
        }

        QueenAttacks();
        KnightAttacks();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    // 퀸의 공격 범위
    static void QueenAttacks() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessBoard[i][j] == 1) { // Queen이 있는 곳
                    for (int k = 0; k < 8; k++) {
                        int x = i + QueenX[k];
                        int y = j + QueenY[k];
                        while (isValid(x, y) && chessBoard[x][y] <= 0) {
                            chessBoard[x][y] = -1; // Queen의 공격 범위
                            x += QueenX[k];
                            y += QueenY[k];
                        }
                    }
                }
            }
        }
    }

    // 나이트의 공격 범위
    static void KnightAttacks() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chessBoard[i][j] == 2) { // Knight가 있는 곳
                    for (int k = 0; k < 8; k++) {
                        int x = i + KnightX[k];
                        int y = j + KnightY[k];
                        if (isValid(x, y) && chessBoard[x][y] == 0) {
                            chessBoard[x][y] = -1; // Knight의 공격 범위
                        }
                    }
                }
            }
        }
    }
    
    // 유효한 좌표인지 확인
    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
