import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 사람 수
            int m = Integer.parseInt(st.nextToken()); // 걸린 시간
            int k = Integer.parseInt(st.nextToken()); // 만든 개수

            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr); // 도착 시간을 오름차순 정렬

            boolean possible = true;
            for(int i = 0; i < n; i++) {
                int time = arr[i]; // 도착 시간
                int num = (time / m) * k; // 도착 시간까지 만들어진 붕어빵 개수

                if (num < i + 1) { // 사람 수보다 만들어진 붕어빵 개수가 적으면
                    possible = false;
                    break;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(possible ? "Possible" : "Impossible").append("\n");
        }
        System.out.print(sb);
    }
}