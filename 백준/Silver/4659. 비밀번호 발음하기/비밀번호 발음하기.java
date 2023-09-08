import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }

            sb.append("<" + input + "> is ");
            sb.append(check(input) ? "acceptable." : "not acceptable.").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean check(String str) {
        boolean includeOneVowel = false;
        boolean threeConsecutive = false;
        boolean sameLetterAgain = false;

        char prevAgain = 0;
        char prev = 0;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (isVowel(now)) {
                includeOneVowel = true;
            }

            if (prevAgain != 0) {
                if (isVowel(prevAgain) && isVowel(prev) && isVowel(now)) {
                    threeConsecutive = true;
                } else if (!isVowel(prevAgain) && !isVowel(prev) && !isVowel(now)) {
                    threeConsecutive = true;
                }
            }

            if (prev != 0) {
                if (prev == now) {
                    if (now != 'e' && now != 'o') {
                        sameLetterAgain = true;
                    }
                }
            }

            prevAgain = prev;
            prev = now;
        }

        if (!includeOneVowel) {
            return false;
        } else if (threeConsecutive) {
            return false;
        } else if (sameLetterAgain) {
            return false;
        }

        return true;
    }

    private static boolean isVowel(char now) {
        if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
            return true;
        }
        return false;
    }

}
