import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        Map<String, TrieNode> childNodes = new TreeMap<>(comparator);
        boolean isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String[] arr) {
            TrieNode thisNode = root;

            for (int i = 0; i < arr.length; i++) {
                String str = arr[i];
                thisNode = thisNode.childNodes.computeIfAbsent(str, key -> new TrieNode());
            }

            thisNode.isLast = true;
        }

        void print() {
            TrieNode thisNode = root;

            printTire(thisNode, 0);

            System.out.println(sb.toString());

        }

        void printTire(TrieNode node, int depth) {
            for (String key : node.childNodes.keySet()) {
                String head = "";
                for (int i = 0; i < depth; i++) {
                    head += "--";
                }

                sb.append(head).append(key).append("\n");

                TrieNode nextNode = node.childNodes.get(key);
                if (nextNode != null) {
                    printTire(nextNode, depth + 1);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Trie trie = new Trie();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] arr = new String[K];
            for (int j = 0; j < K; j++) {
                arr[j] = st.nextToken();
            }
            trie.insert(arr);
        }

        trie.print();
    }

}