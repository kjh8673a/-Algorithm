class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int num = 0;
        int idx = 0;
        while(storey > 0) {
            int tmp = storey % 10; 
            storey /= 10;
            if(tmp < 5) {
                num += tmp * Math.pow(10, idx);
            }else if(tmp == 5) {
                if(storey % 10 >= 5) {
                    answer += 10 - tmp;
                    storey += 1;
                }else {
                    num += tmp * Math.pow(10, idx);
                }
            }else {
                answer += 10 - tmp;
                storey += 1;
            }
            idx++;
        }
        
        while(num > 0) {
            answer += num % 10;
            num /= 10;
        }
        
        return answer;
    }
}