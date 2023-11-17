import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for(int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1]--;
        }
        for(int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                if(i > 0 && arr[i - 1] == 2) {
                    arr[i - 1]--;
                    arr[i]++;
                }else if(i < n - 1 && arr[i + 1] == 2) {
                    arr[i + 1]--;
                    arr[i]++;
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}