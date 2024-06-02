import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += arr[i];
        }

        Arrays.sort(arr);

        int num1 = 0, num2 = 0;
        outer:
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    num1 = arr[i]; // 뺄 값
                    num2 = arr[j]; // 뺄 값
                    break outer; // 두 값 찾으면 바로 빠져나가도록
                }
            }
        }

        for (int i : arr) {
            if(i == num1 || i == num2) continue;
            System.out.println(i);
        }

    }
}
