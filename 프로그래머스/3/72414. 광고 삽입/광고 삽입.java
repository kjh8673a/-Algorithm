class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = calTime(play_time);
        int advTime = calTime(adv_time);
        
        int[] preSum = new int[playTime + 2];
        for(int i = 0; i < logs.length; i++) {
            int start = calTime(logs[i].split("-")[0]);
            int end = calTime(logs[i].split("-")[1]);
            preSum[start]++;
            preSum[end]--;
        }
        
        for(int i = 1; i < playTime + 1; i++) {
            preSum[i] += preSum[i - 1];
        }
        
        long sum = 0;
        for(int i = 0; i < advTime; i++) {
            sum += preSum[i];
        }
        
        long max = sum;
        int ans = 0;
        int adv = advTime;
        for(int i = 0; i < playTime - advTime; i++) {
            sum += preSum[adv++] - preSum[i];
            if(max < sum) {
                max = sum;
                ans = i + 1;
            }
        }
        
        return returnTime(ans);
    }
    
    private static int calTime(String str) {
        int h = Integer.parseInt(str.split(":")[0]);
        int m = Integer.parseInt(str.split(":")[1]);
        int s = Integer.parseInt(str.split(":")[2]);
        
        return h * 3600 + m * 60 + s;
    }
    
    private static String returnTime(int i) {
        String h = String.format("%02d", i / 3600);
        i%= 3600;
        String m = String.format("%02d", i / 60);
        i %= 60;
        String s = String.format("%02d", i);
        
        
        return h + ":" + m + ":" + s;
    }
}