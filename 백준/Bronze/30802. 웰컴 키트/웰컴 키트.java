import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        arr = new int[6];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < 6; i++) {
                count += arr[i] / t;
                if(arr[i] % t != 0) {
                    count++;
                }
        }
        System.out.println(count);

        int q = n / p;
        int r = n % p;
        System.out.println(q + " " + r);
    }
}
