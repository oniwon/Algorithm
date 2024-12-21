import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        // 산술평균
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        double answer = (double) sum / n;
        sb.append((int) Math.round(answer)).append("\n");

        // 중앙값
        sb.append(list.get(n / 2)).append("\n");

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Collections.max(map.values()); // 최대 빈도
        List<Integer> maxList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                maxList.add(entry.getKey());
            }
        }

        Collections.sort(maxList);

        // 최빈값이 여러 개일 경우 두 번째로 작은 값 선택
        if (maxList.size() > 1) {
            sb.append(maxList.get(1)).append("\n");
        } else {
            sb.append(maxList.get(0)).append("\n");
        }

        // 범위
        sb.append(list.get(n - 1) - list.get(0)).append("\n");

        System.out.println(sb);
    }
}
