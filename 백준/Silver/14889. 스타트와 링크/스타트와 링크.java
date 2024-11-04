import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] team;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        team = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) { // 배열 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.println(min);
    }
    
    public static void dfs(int depth, int count) {
        if(count == n/2) { // 재귀 탈출 조건: 팀이 완성
            calculateDifference();
            return;
        }


        for(int i = depth; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true; // 선수 선택
            dfs(i + 1, count + 1); // 다음 선수 선택
            visited[i] = false;
        }
    }
    
    public static void calculateDifference() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        // 스타트 팀의 능력치 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) { // 두 선수가 스타트 팀에 속하는 경우
                    startTeamScore += team[i][j] + team[j][i];
                }
            }
        }

        // 링크 팀의 능력치 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!visited[i] && !visited[j]) { // 두 선수가 링크 팀에 속하는 경우
                    linkTeamScore += team[i][j] + team[j][i];
                }
            }
        }
        
        int difference = Math.abs(startTeamScore - linkTeamScore); // 능력치 차이 계산
        min = Math.min(min, difference); // 최소 차이 갱신
    }
}
