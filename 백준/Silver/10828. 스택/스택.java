import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력 개수
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            String cmd = st.nextToken();

            // push X
            if(cmd.equals("push")) {
                int X = Integer.parseInt(st.nextToken());
                stack.push(X);
            }

            // pop
            else if(cmd.equals("pop")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else sb.append(stack.pop()).append("\n");
            }

            // size
            else if(cmd.equals("size")) {
                sb.append(stack.size()).append("\n");
            }

            // empty
            else if(cmd.equals("empty")) {
                if(stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else sb.append(0).append("\n");
            }


            // top
            else if(cmd.equals("top")) {
                if(stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.print(sb);
    }
}