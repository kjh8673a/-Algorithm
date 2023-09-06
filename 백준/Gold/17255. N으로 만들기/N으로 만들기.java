import java.util.*;
import java.io.*;

public class Main {
    static char[] arr;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();

        set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            dfs(i, i, "" + arr[i], "" + arr[i]);
        }

        System.out.println(set.size());
    }

    private static void dfs(int left, int right, String now, String str) {
        if (left == 0 && right == arr.length - 1) {
            set.add(str);
        }

        if (left > 0) {
            dfs(left - 1, right, arr[left - 1] + now, str + " " + arr[left - 1] + now);
        }

        if (right < arr.length - 1) {
            dfs(left, right + 1, now + arr[right + 1], str + " " + now + arr[right + 1]);
        }

    }

}
