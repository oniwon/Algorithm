import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr; // 입력 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = n - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) { // 배열 끝부터 시작해서 내림차순이 끝나는 지점 찾기
            i--;
        }

        if(i <= 0) { // 마지막 순열일 때 -1 출력
            System.out.println("-1");
            return;
        }

        int j = n - 1;
        while (arr[i - 1] <= arr[j]) { // 배열 끝부터 시작해서 arr[i-1]보다 작은 수 중 가장 오른쪽에 있는 수 찾기
            j--;
        }

        // 두 배열 순서 바꾸기
        swap(i - 1, j);

        // i 부터 끝까지 내림차순 정렬하기(i 이후부터 가장 큰 다음 조합 만들기)
        j = n - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void swap(int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
}