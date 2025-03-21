import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        loop: while (true) {
            List<String> words = new ArrayList<>();
            while (true) {
                String word = br.readLine();
                if (word.equals("#")) {
                    if (words.size() == 0) {
                        break loop;
                    }
                    break;
                }

                words.add(word);
            }

            boolean flag = true;
            loop2: for (int i = 0; i < words.size() - 1; i++) {
                if (!canLadder(words.get(i), words.get(i + 1))) {
                    flag = false;
                    break loop2;
                }
            }

            sb.append(flag ? "Correct" : "Incorrect").append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean canLadder(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

}