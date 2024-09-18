import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력 개수
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int back = 0; // 마지막에 삽입된 숫자

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            String cmd = st.nextToken(); // 입력값 중 앞

            // push
            if(cmd.equals("push")) {
                int X = Integer.parseInt(st.nextToken()); // push 명령어 뒷 숫자
                queue.add(X);
                back = X;
            }

            // pop
            else if (cmd.equals("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }

            // size
            else if (cmd.equals("size")) {
                sb.append(queue.size()).append("\n");
            }

            // empty
            else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }

            // front
            else if (cmd.equals("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }

            // back
            else if(cmd.equals("back")) {
                if (!queue.isEmpty()) {
                    sb.append(back).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}