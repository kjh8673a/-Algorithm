import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;
    static int[] pair;
    static TreeSet<String> set;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = s.toCharArray();

        pair = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                pair[i] = stack.peek();
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        set = new TreeSet<>();
        visit = new boolean[arr.length];
        dfs(0, arr.length);
        set.remove(s);
        
        StringBuilder sb = new StringBuilder();
        set.stream().forEach(ans -> sb.append(ans).append("\n"));

        System.out.println(sb);
    }

    private static void dfs(int idx, int len) {
        if (idx == len) {
            print();
            return;
        }

        if (arr[idx] == '(') {
            visit[idx] = true;
            visit[pair[idx]] = true;
            dfs(idx + 1, len);

            visit[idx] = false;
            visit[pair[idx]] = false;
        }

        dfs(idx + 1, len);
    }

    private static void print() {
        String tmp = "";
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                tmp += arr[i];
            }
        }
        set.add(tmp);
    }

}
