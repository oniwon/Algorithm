import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("L", 1);
        map.put("B", 2);
        map.put("T", 3);
        map.put("RT", 4);
        map.put("LT", 5);
        map.put("RB", 6);
        map.put("LB", 7);

        int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

        String[] input = br.readLine().split(" ");
        String kingPos = input[0]; // 킹의 위치
        String stonePos = input[1]; // 돌의 위치
        int n = Integer.parseInt(input[2]); // 이동 횟수

        // A1 -> (7, 0)
        int kingRow = 8 - (kingPos.charAt(1) - '0');
        int kingCol = kingPos.charAt(0) - 'A';
        int stoneRow = 8 - (stonePos.charAt(1) - '0');
        int stoneCol = stonePos.charAt(0) - 'A';

        for(int i = 0; i < n; i++) {
            int dir = map.get(br.readLine());

            int nextKingRow = kingRow + dr[dir];
            int nextKingCol = kingCol + dc[dir];

            // 킹의 이동 위치가 체스판 내에 있을 경우
            if (nextKingRow >= 0 && nextKingRow < 8 && nextKingCol >= 0 && nextKingCol < 8) {
                // 킹의 이동 위치가 돌과 같은 위치라면 돌도 이동
                if (nextKingRow == stoneRow && nextKingCol == stoneCol) {
                    int nextStoneRow = stoneRow + dr[dir];
                    int nextStoneCol = stoneCol + dc[dir];

                    // 돌이 이동한 위치가 체스판 내에 있을 경우에만 킹과 돌 모두 이동
                    if (nextStoneRow >= 0 && nextStoneRow < 8 && nextStoneCol >= 0 && nextStoneCol < 8) {
                        kingRow = nextKingRow;
                        kingCol = nextKingCol;
                        stoneRow = nextStoneRow;
                        stoneCol = nextStoneCol;
                    }
                } else { // 돌과 충돌이 없으면 킹만 이동
                    kingRow = nextKingRow;
                    kingCol = nextKingCol;
                }
            }
        }
        String kingResult = (char)(kingCol + 'A') + Integer.toString(8 - kingRow);
        String stoneResult = (char)(stoneCol + 'A') + Integer.toString(8 - stoneRow);

        System.out.println(kingResult);
        System.out.println(stoneResult);

        br.close();
    }
}