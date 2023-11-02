import java.util.*;

class Solution {
    
    static int[][] list;
    static int[] route;
    static int[] cnt;
    static ArrayList<Integer> ansList;
    
    public int[] solution(int[][] edges, int[] target) {
        int len = target.length;
        System.out.println(len);
        list = new int[len + 1][len + 1];
        
        for(int i = 0; i < edges.length; i++) {
            list[edges[i][0]][edges[i][1]] = 1;
        }
        
        route = new int[len + 1];
        for(int i = 1; i < len + 1; i++) {
            for(int j = 1; j < len + 1; j++) {
                if(list[i][j] == 1) {
                    route[i] = j;
                    break;
                }
            }
        }
        
        cnt = new int[len + 1];
        ansList = new ArrayList<>();
        
        boolean isPossible = true;
        while(!check(target, cnt)) {
            if(!ansList.isEmpty() && ansList.get(ansList.size() - 1) == -1) {
                isPossible = false;
                break;
            }
            doTree();
        }
        
        if(!isPossible) {
            int[] answer = {-1};
            return answer;
        }else {
            int[] answer = new int[ansList.size()];
            for(int i = 0; i < ansList.size(); i++) {
                System.out.print(ansList.get(i) + " ");
                int num = ansList.get(i);
                if(cnt[num] == 1) {
                    answer[i] = target[num - 1];
                }else {
                    if((target[num - 1] - 1) <= (cnt[num] - 1) * 3) {
                        answer[i] = 1;
                    }else if((target[num - 1] - 2) <= (cnt[num] - 1) * 3) {
                        answer[i] = 2;
                    }else {
                        answer[i] = 3;
                    }
                }
                target[num - 1] -= answer[i];
                cnt[num]--;
            }
            return answer;
        }
    
    }
    
    private static void doTree() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            
            if(route[num] == 0) {
                cnt[num]++;
                ansList.add(num);
                return;
            }
            
            queue.add(route[num]);
            moveRoute(num);            
        }
    }
    
    private static void moveRoute(int num) {
        for(int i = route[num] + 1; i < list[num].length; i++) {
            if(list[num][i] == 1) {
                route[num] = i;
                return;
            }
        }
        
        for(int i = 1; i <= route[num]; i++) {
            if(list[num][i] == 1) {
                route[num] = i;
                return;
            }
        }
    }
    
    private static boolean check(int[] target, int[] cnt) {
        for(int i = 0; i < target.length; i++) {
            if(target[i] == 0 && cnt[i + 1] > 0) {
                ansList.add(-1);
                return false;
            }
            
            if(target[i] > 0) {
                if(cnt[i + 1] == 0) {
                    return false;
                }else if(target[i] / cnt[i + 1] < 1) {
                    ansList.add(-1);
                    return false;
                }else if(target[i] / cnt[i + 1] > 3) {
                    return false;
                }else if(target[i] / cnt[i + 1] == 3 && target[i] % cnt[i + 1] > 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
}