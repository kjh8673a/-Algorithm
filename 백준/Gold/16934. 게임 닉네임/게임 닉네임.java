import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        int isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        String insert(String str) {
            TrieNode thisNode = root;

            String alias = "";
            boolean isDone = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!isDone) {
                    alias += c;
                }
                if (thisNode.childNodes.get(c) == null) {
                    thisNode.childNodes.put(c, new TrieNode());
                    isDone = true;
                }

                thisNode = thisNode.childNodes.get(c);
            }

            thisNode.isLast++;
            if (thisNode.isLast > 1) {
                alias += String.valueOf(thisNode.isLast);
            }
            return alias;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            sb.append(trie.insert(br.readLine())).append("\n");
        }

        System.out.println(sb.toString());

    }

}