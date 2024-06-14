class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
        
        int n = board.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == 0) {
                            board[nr][nc] = 2;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) answer++;
            }
        }
        return answer;
    }
}