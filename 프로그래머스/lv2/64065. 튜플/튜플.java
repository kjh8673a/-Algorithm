import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(String s) {
        List<int[]>[] list = new ArrayList[501];

        Queue<Integer> queue = new LinkedList<>();
        int maxLen = 0;
        int tmp = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                tmp = tmp * 10 + (s.charAt(i) - '0');
            }else if(s.charAt(i) == ',' && tmp != 0) {
                queue.add(tmp);
                tmp = 0;
            }else if(s.charAt(i) == '}' && tmp != 0) {
                queue.add(tmp);
                tmp = 0;
                int len = queue.size();
                if(len > maxLen) {
                    maxLen = len;
                }
                int[] arr = new int[len];
                int idx = 0;
                while(!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
                list[len] = new ArrayList<>();
                list[len].add(arr);
            }
        }

        int[] answer = new int[maxLen];

        boolean[] visit = new boolean[100001];
        int idx = 0;
        for(int i = 1; i <= maxLen; i++) {
            int[] arr = list[i].get(0);
            for(int j = 0; j < arr.length; j++) {
                if(!visit[arr[j]]) {
                    answer[idx++] = arr[j];
                    visit[arr[j]] = true;
                }
            }
        }
        
        return answer;
    }
}