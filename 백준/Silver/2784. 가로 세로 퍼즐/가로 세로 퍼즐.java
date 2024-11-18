import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] words = new String[6];
    static String[] result = new String[6];
    static boolean[] visited = new boolean[6];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 6; i++) { // 6개 단어 입력
            words[i] = br.readLine();
        }

        Arrays.sort(words); // 사전순 정렬

        dfs(0);

        if (!found) {
            System.out.println(0);
        }
    }

    public static void dfs(int count) {
        if (found) return; // 이미 찾았으면 더 이상 탐색X

        if (count == 6) {
            char[] row, col;
            for (int i = 0; i < 3; i++) {
                col = result[i + 3].toCharArray(); // 세로 방향 단어
                for (int j = 0; j < 3; j++) {
                    row = result[j].toCharArray(); // 가로 방향 단어
                    if (row[i] != col[j]) // 세로 단어와 가로 단어가 일치하지 않으면 return
                        return;
                }
            }

            // 조건을 만족하는 경우
            found = true;
            for (int i = 0; i < 3; i++) {
                System.out.println(result[i]);
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[count] = words[i]; // result 배열에 단어 채우기
            dfs(count + 1);
            visited[i] = false;
        }
    }
}