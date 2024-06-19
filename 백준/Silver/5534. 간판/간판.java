import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String name = br.readLine();

        int count = 0;
        loop: for (int i = 0; i < n; i++) {
            char[] board = br.readLine().toCharArray();

            for (int j = 0; j < board.length; j++) {
                if (board[j] == name.charAt(0)) {
                    for (int dist = 1; dist <= board.length; dist++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = j; k < board.length && sb.length() < name.length(); k += dist) {
                            sb.append(board[k]);
                        }
                        if (sb.toString().equals(name)) {
                            count++;
                            continue loop;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}