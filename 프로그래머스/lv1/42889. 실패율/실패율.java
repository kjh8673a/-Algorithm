class Solution {
    public int[] solution(int N, int[] stages) {
        double[] fail = new double[N];
        int[] answer = new int[N];
        int people = stages.length;

        for(int i = 0; i < N; i++) {
            if(people == 0) {
                fail[i] = 0;
            }else{
                for(int j = 0; j < stages.length; j++) {
                    if(stages[j] == i+1) {
                        fail[i]++;
                    }
                }
                people -= fail[i];
                fail[i] = fail[i] / (people+fail[i]);
            }
        }

        for(int i = 0; i < answer.length; i++) {
            double max = fail[0];
            answer[i] = 1;
            for(int j = 1; j < fail.length; j++) {
                if(max < fail[j]) {
                    max = fail[j];
                    answer[i] = j+1;
                }
            }
            fail[answer[i]-1] = -1;
        }

        return answer;
    }
}