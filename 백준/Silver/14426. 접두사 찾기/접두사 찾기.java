import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class TrieNode {
        // TrieNode를 계속 타고들어갈 수 있게 HashMap으로 만든다
        Map<Character, TrieNode> childNodes = new HashMap<>();
        // 해당 문자가 마지막인지 기록
        boolean isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String str) {
            TrieNode thisNode = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 넣으려고 하는 문자가 없으면 새로 추가한다(put)
                if (thisNode.childNodes.get(c) == null) {
                    thisNode.childNodes.put(c, new TrieNode());
                }
                // 현재 문자(c)의 TrieNode로 타고들어간다
                thisNode = thisNode.childNodes.get(c);
            }

            // 끝까지 기록했으면 isLast에 true를 넣어준다
            thisNode.isLast = true;
        }

        boolean search(String str) {
            TrieNode thisNode = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                thisNode = thisNode.childNodes.get(c);
                // 아직 문자가 남았는데 타고들어갈 TrieNode가 없으면
                // false를 반환한다
                if (thisNode == null) {
                    return false;
                }
            }

            // 끝까지 반복문을 통과했다면 true를 반환한다
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            trie.insert(str);
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (trie.search(str)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}