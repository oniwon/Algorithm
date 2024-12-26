import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[j].equals(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    int num = (i%n) + 1;
                    int turn = (i/n) + 1;
                    return new int[]{num, turn};
                }
            }
        }

        return answer;
    }
}