import java.io.*;
import java.util.*;

public class Main {
    static class ChatGPT {
        Map<Character, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        int index = -1;

        Map<Character, Character> dictionary = new HashMap<>();

        public void train(String input) {
            for (int i = 0; i < input.length() - 1; i++) {
                char node = input.charAt(i);
                char next = input.charAt(i + 1);
                if (map.containsKey(node)) {
                    int idx = map.get(node);
                    list.get(idx).add(next);
                } else {
                    list.add(new ArrayList<>());
                    this.index++;
                    map.put(node, index);
                    list.get(index).add(next);
                }
            }
        }

        public void makeDictionary() {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();

                Map<Character, Integer> tmp = new HashMap<>();
                for (Character next : list.get(value)) {
                    tmp.put(next, tmp.getOrDefault(next, 0) + 1);
                }

                int cnt = 0;
                char result = 0;
                for (Map.Entry<Character, Integer> tmpEntry : tmp.entrySet()) {
                    Character tmpKey = tmpEntry.getKey();
                    Integer tmpValue = tmpEntry.getValue();
                    if (cnt < tmpValue) {
                        result = tmpKey;
                        cnt = tmpValue;
                    } else if (cnt == tmpValue) {
                        if (result - tmpKey > 0) {
                            result = tmpKey;
                        }
                    }
                }

                dictionary.put(key, result);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ChatGPT gpt = new ChatGPT();
        for (int i = 0; i < n; i++) {
            gpt.train(br.readLine());
        }
        gpt.makeDictionary();

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        char node = '[';
        while (idx < k + m) {
            if (idx >= k) {
                sb.append(node);
            }

            if (node != ']' && node != '.') {
                node = gpt.dictionary.get(node);
            } else {
                node = '.';
            }

            idx++;
        }

        System.out.println(sb);
    }
}