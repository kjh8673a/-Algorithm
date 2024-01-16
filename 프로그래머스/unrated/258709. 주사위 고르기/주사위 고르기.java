import java.util.*;

class Solution {
    static int n, maxWin, bestSelected;
    static int[][] dice;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        this.dice = dice;
        maxWin = 0;
        bestSelected = 0;
        getDice(0, 0);
        
        
        
        int[] answer = new int[n / 2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if((bestSelected & (1 << i)) > 0) {
                    answer[idx++] = i + 1;
                }
        }
        
        return answer;
    }
    
    private static void getDice(int idx, int selected) {
        if(idx == n) {
            if(Integer.bitCount(selected) == n / 2) {
                calculateWinRate(selected);
            }
            return;
        }
        
        getDice(idx + 1, selected);
        getDice(idx + 1, selected + (1 << idx));
    }
    
    static Map<Integer, Integer> scoreA;
    static Map<Integer, Integer> scoreB;
    private static void calculateWinRate(int selected) {
        scoreA = new HashMap<>();
        scoreB = new HashMap<>();
        
        rollDice(0, selected, new int[n / 2]);
        
        int win = 0;
        for (Map.Entry<Integer, Integer> entryA : scoreA.entrySet()) {
            int keyA = entryA.getKey();
            int valueA = entryA.getValue();
            for(Map.Entry<Integer, Integer> entryB : scoreB.entrySet()) {
                int keyB = entryB.getKey();
                int valueB = entryB.getValue();
                if(keyA > keyB) {
                    win += valueA * valueB;
                }
            }
        }
        
        if(maxWin < win) {
            maxWin = win;
            bestSelected = selected;
        }
        
    }
    
    private static void rollDice(int idx, int selected, int[] rolledDice) {
        if(idx == n / 2) {
            int[] diceA = new int[n / 2];
            int[] diceB = new int[n / 2];
            int idxA = 0;
            int idxB = 0;
            for(int i = 0; i < n; i++) {
                if((selected & (1 << i)) > 0) {
                    diceA[idxA++] = i;
                }else {
                    diceB[idxB++] = i;
                }
            }
            
            int sumA = 0;
            int sumB = 0;
            for(int i = 0; i < n / 2; i++) {
                int num = rolledDice[i];
                sumA += dice[diceA[i]][num];
                sumB += dice[diceB[i]][num];
            }
            
            scoreA.put(sumA, scoreA.getOrDefault(sumA, 0) + 1);
            scoreB.put(sumB, scoreB.getOrDefault(sumB, 0) + 1);
            
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            rolledDice[idx] = i;
            rollDice(idx + 1, selected, rolledDice);
        }
    }
}