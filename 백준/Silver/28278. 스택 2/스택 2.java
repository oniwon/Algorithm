import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String t = st.nextToken();

            if (t.equals("1")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (t.equals("2")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (t.equals("3")) {
                sb.append(stack.size()).append("\n");
            } else if (t.equals("4")) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (t.equals("5")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
