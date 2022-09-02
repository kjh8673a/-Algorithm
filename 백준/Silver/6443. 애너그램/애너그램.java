import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[] strArr;
    static ArrayList<String> list;
    static int[] alpha;
    static int len;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            strArr = str.toCharArray();

            len = strArr.length;
            alpha = new int[26];

            for (char ch : strArr) {
                alpha[ch - 97]++;
            }

            list = new ArrayList<>();

            anagram(0, "");

            for(String s : list) {
                sb.append(s).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static void anagram(int idx, String str) {
        if (idx == len) {
            list.add(str);
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                alpha[i]--;
                anagram(idx + 1, str + (char) (i + 97));
                alpha[i]++;
            }
        }
    }

}