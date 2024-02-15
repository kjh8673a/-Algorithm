import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kind = new HashSet<>();
        for(String gem : gems) {
            kind.add(gem);
        }
        int size = kind.size();
        
        int[] answer = {1, gems.length};
        
        Map<String, Integer> map = new HashMap<>();
        for(int start = 0, end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if(map.size() == size && (end - start) < (answer[1] - answer[0])) {
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        return answer;
    }
}