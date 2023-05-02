import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int point = 0;
        String word = words[0];
        Set<String> set = new HashSet<>();
        set.add(word);
        for(int i = 1; i < words.length; i++) {
            if(!word.endsWith(String.valueOf(words[i].charAt(0))) || set.contains(words[i])) {
                point = i + 1;
                break;
            }else {
                word = words[i];
                set.add(word);
            }
        }
        System.out.println(point);
        
        int a = point % n;
        if(point != 0 && a == 0) {
            a = n;
        }
        int b = point / n;
        if(point % n != 0) {
            b++;
        }
        
        int[] answer = {a, b};

        return answer;
    }
}