import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        map = new HashMap<>() {
            {
                put("000000", "A");
                put("001111", "B");
                put("010011", "C");
                put("011100", "D");
                put("100110", "E");
                put("101001", "F");
                put("110101", "G");
                put("111010", "H");
            }
        };

        String msg = "";
        for (int i = 0; i < line.length(); i += 6) {
            String tmp = line.substring(i, i + 6);
            if (map.containsKey(tmp)) {
                msg += map.get(tmp);
            } else {
                String chk = checkSimilarity(tmp);
                if (chk.length() != 1) {
                    msg = String.valueOf(i / 6 + 1);
                    break;
                } else {
                    msg += chk;
                }
            }
        }

        System.out.println(msg);
    }

    private static String checkSimilarity(String str) {
        int count = 10;
        String result = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            int tmp = 0;
            for (int i = 0; i < key.length(); i++) {
                if (str.charAt(i) != key.charAt(i)) {
                    tmp++;
                }
            }

            if (count > tmp) {
                count = tmp;
                result = entry.getValue();
            } else if (count == tmp) {
                result = "UNKNOWN";
            }
        }

        return result;
    }
}