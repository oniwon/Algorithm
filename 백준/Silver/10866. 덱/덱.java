import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            // push_front X
            if(cmd.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addFirst(x);
            }

            // push_back X:
            else if(cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque.addLast(x);
            }

            // pop_front
            else if(cmd.equals("pop_front")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else sb.append("-1").append("\n");
            }

            // pop_back
            else if(cmd.equals("pop_back")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else sb.append("-1").append("\n");
            }

            // size
            else if(cmd.equals("size")) {
                sb.append(deque.size()).append("\n");
            }

            // empty
            else if(cmd.equals("empty")) {
                if(deque.isEmpty()) {
                    sb.append("1").append("\n");
                } else sb.append("0").append("\n");
            }

            // front
            else if(cmd.equals("front")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.getFirst()).append("\n");
                } else sb.append("-1").append("\n");
            }

            // back
            else if(cmd.equals("back")) {
                if(!deque.isEmpty()) {
                    sb.append(deque.getLast()).append("\n");
                } else sb.append("-1").append("\n");
            }
        }
        System.out.println(sb);
    }
}