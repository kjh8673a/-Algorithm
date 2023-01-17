import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int maxNum = 0;
        String maxBook = "";
        for (String key : map.keySet()) {
            int num = map.get(key);
            if (num > maxNum) {
                maxNum = num;
                maxBook = key;
            }
        }

        System.out.println(maxBook);

    }

}