import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[n - 1];

        while (left <= right) {
            long count = 0;
            long middle = (left + right)/2;

            for(int i = 0; i < n; i++) {
                if (arr[i] > middle) {
                    count += (arr[i] - middle);
                }
            }

            if(count < m) {
                right = middle - 1; // 절단기 높이 낮추기
            } else left = middle + 1; // 절단기 높이 높이기
        }
        System.out.println(right);
    }
}
