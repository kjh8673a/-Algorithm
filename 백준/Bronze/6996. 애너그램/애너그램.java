import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        if (first.length() != second.length()) {
            return false;
        } else {
            String[] arr_first = new String[first.length()];
            String[] arr_second = new String[second.length()];

            for (int j = 0; j < first.length(); j++) {
                arr_first[j] = String.valueOf(first.charAt(j));
            }

            for (int j = 0; j < second.length(); j++) {
                arr_second[j] = String.valueOf(second.charAt(j));
            }

            Arrays.sort(arr_first);
            Arrays.sort(arr_second);

            boolean check = true;
            for (int j = 0; j < arr_first.length; j++) {
                if (!arr_first[j].equals(arr_second[j])) {
                    check = false;
                    break;
                }
            }
            return check;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
