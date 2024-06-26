import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Point> list = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point p = new Point(x, y);
            list.add(p);
        }

        Collections.sort(list, new PointCompare());

        for(Point p: list) {
            System.out.println(p);
        }

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }

    static class PointCompare implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if(o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        }
    }
}
