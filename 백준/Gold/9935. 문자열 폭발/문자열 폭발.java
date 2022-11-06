import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        char lastBomb = bomb.charAt(bomb.length() - 1);

        Character[] arr = new Character[str.length()];
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 현재 문자가 폭발문자열의 마지막글자와 같고
            // 저장된 문자열의 길이가 폭발문자열의 길이 이상일 경우
            if (ch == lastBomb && idx + 1 >= bomb.length()) {
                boolean isBomb = true;
                int tmpIdx = idx - 1;
                for (int j = bomb.length() - 2; j >= 0; j--) {
                    if (bomb.charAt(j) != arr[tmpIdx--]) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발문자열이 있을 경우 인덱스를 그 위치로 돌린다
                if (isBomb) {
                    idx = idx - bomb.length() + 1;
                }
                // 폭발문자열이 없으면 현재 문자를 배열에 추가한다
                else {
                    arr[idx++] = ch;
                }
            } else {
                arr[idx++] = ch;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(arr[i]);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}