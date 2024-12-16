import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distance = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

            if (x1 == x2 && y1 == y2 && r1 == r2) { // 두 원의 중심이 같고 반지름도 같다면 무한대
                sb.append("-1\n");
            }

            else if (Math.pow(r1 + r2, 2) < distance) { // 두 원이 서로 외부에 있어 교점이 없는 경우
                sb.append("0\n");
            }

            else if (Math.pow(r1 - r2, 2) > distance) { // 한 원이 다른 원 안에 있어 교점이 없는 경우
                sb.append("0\n");
            }

            else if (Math.pow(r1 + r2, 2) == distance) { // 외접하는 경우
                sb.append("1\n");
            }

            else if (Math.pow(r1 - r2, 2) == distance) { // 내접하는 경우
                sb.append("1\n");
            }

            else { // 두 원이 서로 다른 두 점에서 만나는 경우
                sb.append("2\n");
            }
        }

        System.out.println(sb);
    }
}
