import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    static int user_len, banned_len, index;
    static String[] res;
    static HashSet<String> set;
    static ArrayList<String>[] list;

    static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLast;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String str) {
            TrieNode thisNode = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (thisNode.childNodes.get(c) == null) {
                    thisNode.childNodes.put(c, new TrieNode());
                }

                thisNode = thisNode.childNodes.get(c);
            }

            thisNode.isLast = true;
        }

        String[] search(String str) {
            res = new String[user_len];

            TrieNode thisNode = root;
            index = 0;
            deep_search(str, 0, thisNode, "");

            return res;
        }

        void deep_search(String str, int idx, TrieNode thisNode, String result) {
            if (idx == str.length()) {
                if (thisNode.isLast) {
                    res[index++] = result;
                }
                return;
            }

            char c = str.charAt(idx);
            if (c != '*') {
                if (thisNode.childNodes.get(c) == null) {
                    return;
                } else {
                    deep_search(str, idx + 1, thisNode.childNodes.get(c), result + c);
                }
            } else {
                for (Character key : thisNode.childNodes.keySet()) {
                    deep_search(str, idx + 1, thisNode.childNodes.get(key), result + key);
                }
            }
        }

    }

    public static int solution(String[] user_id, String[] banned_id) {
        Trie trie = new Trie();

        user_len = user_id.length;
        banned_len = banned_id.length;

        // user_id를 Trie에 삽입한다
        for (int i = 0; i < user_len; i++) {
            trie.insert(user_id[i]);
        }

        list = new ArrayList[banned_len];
        for (int i = 0; i < banned_len; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < banned_len; i++) {
            String[] arr = trie.search(banned_id[i]);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == null) {
                    break;
                }
                list[i].add(arr[j]);
            }
        }

        set = new HashSet<>();
        boolean[] visit = new boolean[user_len];
        dfs(0, visit, user_id);

        int answer = set.size();
        return answer;
    }

    public static void dfs(int idx, boolean[] visit, String[] user_id) {
        if (idx == banned_len) {
            String ans = "";
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    ans += String.valueOf(i);
                }
            }
            set.add(ans);
            return;
        }

        for (String key : list[idx]) {
            int num = 0;
            for (int i = 0; i < user_len; i++) {
                if (key.equals(user_id[i])) {
                    num = i;
                    break;
                }
            }
            if (!visit[num]) {
                visit[num] = true;
                dfs(idx + 1, visit, user_id);
                visit[num] = false;
            }
        }
    }
}