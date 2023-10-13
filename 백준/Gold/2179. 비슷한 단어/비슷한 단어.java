import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!list.contains(word)) {
                list.add(word);
            }
        }

        int max = 0;
        int idx_s = 0;
        int idx_t = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            String s = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                String t = list.get(j);

                int tmp = 0;
                for (int k = 0; k < Math.min(s.length(), t.length()); k++) {
                    if (s.charAt(k) == t.charAt(k)) {
                        tmp++;
                    } else {
                        break;
                    }
                }

                if (tmp > max) {
                    max = tmp;
                    idx_s = i;
                    idx_t = j;
                }
            }
        }

        System.out.println(list.get(idx_s));
        System.out.println(list.get(idx_t));
    }

}
