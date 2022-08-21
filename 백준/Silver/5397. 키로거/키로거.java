import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            LinkedList<Character> pwd = new LinkedList<>();

            String str = br.readLine();

            int cursor = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                switch(ch) {
                    case '<' :
                        if(cursor >0) cursor--;
                        break;
                    case '>' :
                        if(cursor < pwd.size()) cursor++;
                        break;
                    case '-' :
                        if(cursor > 0) pwd.remove(--cursor);
                        break;
                    default :
                        pwd.add(cursor++, ch);
                        break;
                }
            }

            Iterator<Character> iter = pwd.iterator();
            while(iter.hasNext()) {
                sb.append(iter.next());
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());

    }

}
