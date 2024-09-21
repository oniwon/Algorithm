import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // n 명의 사람
        int k = Integer.parseInt(st.nextToken()); // k 번째 제거

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i = 1; i <= n; i++) { // 1부터 n 까지의 사람을 큐에 넣기
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) { // k 번째 사람이 나오기 전까지 큐에서 빼서 다시 넣기
                queue.add(queue.poll());
            }

            sb.append(queue.poll()); // k 번째 제거

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}