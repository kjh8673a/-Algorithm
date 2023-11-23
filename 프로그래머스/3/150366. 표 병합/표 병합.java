import java.util.*;

class Solution {
    static int[] parent = new int[2501];
    static String[] table = new String[2501];
    static List<String> resultList;
    
    private static void init() {
        parent = new int[2501];
        table = new String[2501];
        resultList = new ArrayList<>();
        
        for(int i = 1; i < 2501; i++) {
            parent[i] = i;
            table[i] = "";
        }
    }
    
    private static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[py] = px;
    }
    
    public String[] solution(String[] commands) {
        init();
        
        for(String command : commands) {
            String[] line = command.split(" ");
            switch(line[0]) {
                case "UPDATE":
                    if(line.length == 4) {
                        updateOneCell(getCellNumber(line[1], line[2]), line[3]);
                    }else {
                        updateCellAtoB(line[1], line[2]);
                    }
                    break;
                    
                case "MERGE":
                    mergeCell(getCellNumber(line[1], line[2]), getCellNumber(line[3], line[4]));
                    break;
                    
                case "UNMERGE":
                    unMergeCell(getCellNumber(line[1], line[2]));
                    break;
                    
                case "PRINT":
                    printCell(getCellNumber(line[1], line[2]));
                    break;
            }
        }
        
        String[] answer = resultList.toArray(new String[resultList.size()]);
        return answer;
    }
    
    private static int getCellNumber(String a, String b) {
        int r = Integer.parseInt(a);
        int c = Integer.parseInt(b);
        
        return 50 * (r - 1) + c;
    }
    
    private static void updateOneCell(int idx, String val) {
        table[find(idx)] = val;
    }
    
    private static void updateCellAtoB(String val1, String val2) {
        for(int i = 1; i < 2501; i++) {
            if(table[i].equals(val1)) {
                table[i] = val2;
            }
        }
    }
    
    private static void mergeCell(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) {
            return;
        }
        
        String val = table[rootA];
        if(val.length() == 0) {
            val = table[rootB];
        }
        table[rootA] = val;
        table[rootB] = "";
        
        union(rootA, rootB);
    }
    
    private static void unMergeCell(int idx) {
        int root = find(idx);
        String val = table[root];
        
        List<Integer> tmpList = new ArrayList<>();
        for(int i = 1; i < 2501; i++) {
            if(find(i) == root) {
                tmpList.add(i);
            }
        }
        
        for(Integer a : tmpList) {
            parent[a] = a;
        }
        
        table[root] = "";
        table[idx] = val;
    }
    
    private static void printCell(int idx) {
        String val = table[find(idx)];
        if(val.length() == 0) {
            val = "EMPTY";
        }
        
        resultList.add(val);
    }
    
}