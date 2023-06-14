import java.io.*;
import java.util.*;

public class Main {
    static int[] digit = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        makeNum(0, 0);

        Collections.sort(list);

        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }

    }

    private static void makeNum(long num, int idx) {

        if (idx == 10) {
            if (!list.contains(num)) {
                list.add(num);
            }
            return;
        }

        makeNum(num, idx + 1);
        makeNum(num * 10 + digit[idx], idx + 1);
    }

}
