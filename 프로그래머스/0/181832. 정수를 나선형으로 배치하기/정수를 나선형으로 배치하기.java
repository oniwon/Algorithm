class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0, c = 0;
        int d = 1;
        int num = 1;
        
        while(num <= n * n) {
            answer[r][c] = num;
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            } 
            
            num++;
            r = nr;
            c = nc;
        }
        
        return answer;
    }
}