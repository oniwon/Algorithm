public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001]; // 1~10000

        for(int i = 1; i <= 10000; i++) {
            int num = i;
            int sum = num;

            // 자릿수 합
            while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }

            if(sum <= 10000) {
                arr[sum] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            if(arr[i] == 0) sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
