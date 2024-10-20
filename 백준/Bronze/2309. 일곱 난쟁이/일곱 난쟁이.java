import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i]; // 난쟁이 키 총합
        }

        Arrays.sort(arr); // 오름차순 정렬

        int num1 = 0, num2 = 0;
        for(int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) { // 두 값을 빼서 합이 100인 두 숫자를 찾음
                    num1 = arr[i];
                    num2 = arr[j];
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i] != num1 && arr[i] != num2) { // 범인 제외
                System.out.println(arr[i]);
            }
        }
    }
}
