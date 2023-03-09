class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            arrX[X.charAt(i) - '0']++;
        }
        for(int i = 0; i < Y.length(); i++) {
            arrY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(arrX[i] > 0 && arrY[i] > 0) {
                sb.append(i);
                arrX[i]--;
                arrY[i]--;
            }
        }
        
        answer = sb.toString();
        
        if(answer.length() == 0) {
            answer = "-1";
        }
        
        if(answer.startsWith("0")) {
            answer = "0";
        }
        
        return answer;
    }
}