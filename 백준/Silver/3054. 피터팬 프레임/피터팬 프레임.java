import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        ArrayList<Character>[] listArr = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            listArr[i] = new ArrayList<>();
        }

        int idx = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (i > 0) {
                idx--;
                for (int j = 0; j < 5; j++) {
                    listArr[j].remove(idx);
                }
            }

            // 1
            listArr[0].add(idx, '.');
            listArr[1].add(idx, '.');
            if ((i + 1) % 3 == 0 || (i > 0 && i % 3 == 0)) {
                listArr[2].add(idx, '*');
            } else {
                listArr[2].add(idx, '#');
            }
            listArr[3].add(idx, '.');
            listArr[4].add(idx, '.');
            idx++;

            // 2
            listArr[0].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[1].add(idx, '*');
            } else {
                listArr[1].add(idx, '#');
            }
            listArr[2].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[3].add(idx, '*');
            } else {
                listArr[3].add(idx, '#');
            }
            listArr[4].add(idx, '.');
            idx++;

            // 3
            if ((i + 1) % 3 == 0) {
                listArr[0].add(idx, '*');
            } else {
                listArr[0].add(idx, '#');
            }
            listArr[1].add(idx, '.');
            listArr[2].add(idx, ch);
            listArr[3].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[4].add(idx, '*');
            } else {
                listArr[4].add(idx, '#');
            }
            idx++;

            // 4
            listArr[0].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[1].add(idx, '*');
            } else {
                listArr[1].add(idx, '#');
            }
            listArr[2].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[3].add(idx, '*');
            } else {
                listArr[3].add(idx, '#');
            }
            listArr[4].add(idx, '.');
            idx++;

            // 5
            listArr[0].add(idx, '.');
            listArr[1].add(idx, '.');
            if ((i + 1) % 3 == 0) {
                listArr[2].add(idx, '*');
            } else {
                listArr[2].add(idx, '#');
            }
            listArr[3].add(idx, '.');
            listArr[4].add(idx, '.');
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (char ch : listArr[i]) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}