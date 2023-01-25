import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        TreeMap<String, TrieNode> childNodes = new TreeMap<>();
        boolean isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String str) {
            TrieNode thisNode = root;

            String tmp = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != '\\') {
                    tmp += c;
                }
                if (c == '\\' || i == str.length() - 1) {
                    if (thisNode.childNodes.get(tmp) == null) {
                        thisNode.childNodes.put(tmp, new TrieNode());
                    }
                    thisNode = thisNode.childNodes.get(tmp);
                    tmp = "";
                }
            }

            thisNode.isLast = true;
        }

        void print() {
            TrieNode thisNode = root;

            printTrie(thisNode, 0);

            System.out.println(sb.toString());
        }

        void printTrie(TrieNode node, int depth) {
            for (String key : node.childNodes.keySet()) {
                String blank = "";
                for (int i = 0; i < depth; i++) {
                    blank += " ";
                }

                sb.append(blank + key + "\n");

                TrieNode nextNode = node.childNodes.get(key);
                if (nextNode != null) {
                    printTrie(nextNode, depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        trie.print();
    }

}