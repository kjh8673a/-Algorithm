import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        list = new ArrayList<>();
        makeBit("", 0);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(o1, 2);
                int num2 = Integer.parseInt(o2, 2);

                if (Integer.bitCount(num1) == Integer.bitCount(num2)) {
                    String tmp1 = "";
                    String tmp2 = "";
                    for (int i = n - 1; i >= 0; i--) {
                        tmp1 += o1.charAt(i);
                        tmp2 += o2.charAt(i);
                    }

                    return Integer.parseInt(tmp1, 2) - Integer.parseInt(tmp2, 2);
                }

                return Integer.bitCount(num1) - Integer.bitCount(num2);
            }
        });

        System.out.println(list.indexOf(s));
    }

    private static void makeBit(String num, int depth) {
        if (depth == n) {
            list.add(num);
            return;
        }

        makeBit(num + "0", depth + 1);
        makeBit(num + "1", depth + 1);
    }

}