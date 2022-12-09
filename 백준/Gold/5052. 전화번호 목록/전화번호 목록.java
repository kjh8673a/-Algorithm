import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class TrieNode {
        // TrieNode를 계속 타고들어갈 수 있게 HashMap으로 만든다
        Map<Character, TrieNode> childNodes = new HashMap<>();
        // 해당 문자가 마지막인지 기록
        boolean isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        boolean insert(String num) {
            TrieNode thisNode = root;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                // 넣으려고 하는 문자가 없으면 새로 추가한다(put)
                if (thisNode.childNodes.get(c) == null) {
                    thisNode.childNodes.put(c, new TrieNode());
                }
                // 현재 문자(c)의 TrieNode로 타고들어간다
                thisNode = thisNode.childNodes.get(c);

                // 넣는 도중 isLast에 true가 기록되어있으면
                // 이미 기록된 문자가 있으므로 일관성이 없다 -> false반환
                if (thisNode.isLast) {
                    return false;
                }
            }

            // 문자를 다 입력했는데 저장된 문자가 더 있다면
            // 다른 문자열의 일부라는 것. 일관성이 없다 -> false반환
            if (thisNode.childNodes.size() != 0) {
                return false;
            }

            // 일관성이 있는 번호이다 -> true기록 / 반환
            thisNode.isLast = true;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            Trie trie = new Trie();
            boolean isConsistent = true;

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String num = br.readLine();

                if (!trie.insert(num)) {
                    isConsistent = false;
                }
            }

            if (isConsistent) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}