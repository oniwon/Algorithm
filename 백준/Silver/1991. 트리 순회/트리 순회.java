import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static Map<String, String[]> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.put(node, new String[]{left, right}); // 노드를 키값으로
        }

        preOrder("A"); // 전위 순회
        System.out.println();
        inOrder("A"); // 중위 순회
        System.out.println();
        postOrder("A"); // 후위 순회
    }


    private static void preOrder(String node) {
        if (node.equals(".")) return;
        System.out.print(node); // 자기 자신
        preOrder(tree.get(node)[0]); // 왼쪽 자식 순회
        preOrder(tree.get(node)[1]); // 오른쪽 자식 순회
    }

    private static void inOrder(String node) {
        if (node.equals(".")) return;
        inOrder(tree.get(node)[0]); // 왼쪽 자식 순회
        System.out.print(node); // 자기 자신
        inOrder(tree.get(node)[1]); // 오른쪽 자식 순회
    }

    private static void postOrder(String node) {
        if (node.equals(".")) return;
        postOrder(tree.get(node)[0]); // 왼쪽 자식 순회
        postOrder(tree.get(node)[1]); // 오른쪽 자식 순회
        System.out.print(node); // 자기 자신
    }
}