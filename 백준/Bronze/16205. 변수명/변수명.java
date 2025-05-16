import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());
        String word = st.nextToken();

        String[] token = null;

        switch (type) {
            case 1:
                token = camelToToken(word);
                break;

            case 2:
                token = snakeToToken(word);
                break;

            case 3:
                token = pascalToToken(word);
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(makeCamelCase(token)).append("\n");
        sb.append(makeSnakeCase(token)).append("\n");
        sb.append(makePascalCase(token)).append("\n");

        System.out.println(sb.toString());
    }

    private static Object makePascalCase(String[] token) {
        String result = "";

        for (int i = 0; i < token.length; i++) {
            String tmp = token[i];
            result += String.valueOf(tmp.charAt(0)).toUpperCase();
            result += tmp.substring(1);
        }

        return result;
    }

    private static Object makeSnakeCase(String[] token) {
        String result = "";

        for (int i = 0; i < token.length; i++) {
            result += token[i];
            if (i != token.length - 1) {
                result += "_";
            }
        }

        return result;
    }

    private static Object makeCamelCase(String[] token) {
        String result = "";

        for (int i = 0; i < token.length; i++) {
            if (i == 0) {
                result += token[i];
                continue;
            }

            String tmp = token[i];
            result += String.valueOf(tmp.charAt(0)).toUpperCase();
            result += tmp.substring(1);
        }

        return result;
    }

    private static String[] pascalToToken(String word) {
        ArrayList<String> list = new ArrayList<>();

        String tmp = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                if (tmp.length() > 0) {
                    list.add(tmp);
                    tmp = "";
                }
                tmp += String.valueOf(ch).toLowerCase();
            } else {
                tmp += ch;
            }
        }
        if (tmp.length() > 0) {
            list.add(tmp);
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private static String[] snakeToToken(String word) {
        return word.split("_");
    }

    private static String[] camelToToken(String word) {
        ArrayList<String> list = new ArrayList<>();

        String tmp = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isUpperCase(ch)) {
                list.add(tmp);
                tmp = "";
                tmp += String.valueOf(ch).toLowerCase();
            } else {
                tmp += ch;
            }
        }
        if (tmp.length() > 0) {
            list.add(tmp);
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
