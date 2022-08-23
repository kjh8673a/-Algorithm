import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] arr;
    static int max;
    static StringBuilder sb = new StringBuilder();
    static String pre;
    static String in;
    static String post;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strArr = new String[N];
        for(int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }
        Arrays.sort(strArr);

        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();

        max = 0;
        while (N != cnt) {
            String str1 = strArr[cnt].split(" ")[0];
            String str2 = strArr[cnt].split(" ")[1];
            String str3 = strArr[cnt].split(" ")[2];

            map.put(str1, map.getOrDefault(str1, 1));
            map.put(str2, map.get(str1) * 2);
            map.put(str3, map.get(str1) * 2 + 1);

            max = Math.max(max, map.get(str3));
            cnt++;
        }

        map.remove(".");

        arr = new String[max + 1];

        for (String Key : map.keySet()) {
            arr[map.get(Key)] = Key;
        }

        preOrder(1);
        inOrder(1);
        postOrder(1);
        
        sb.append(pre.replaceAll("null", "")).append("\n");
        sb.append(in.replaceAll("null", "")).append("\n");
        sb.append(post.replaceAll("null", "")).append("\n");
        
        System.out.println(sb.toString());
    }

    public static void preOrder(int idx) {
        if (idx > max) return;
        pre += arr[idx];
        preOrder(idx * 2);
        preOrder(idx * 2 + 1);
    }

    public static void inOrder(int idx) {
        if (idx > max) return;
        inOrder(idx * 2);
        in += arr[idx];
        inOrder(idx * 2 + 1);
    }

    public static void postOrder(int idx) {
        if (idx > max) return;
        postOrder(idx * 2);
        postOrder(idx * 2 + 1);
        post += arr[idx];
    }

}