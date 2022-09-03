import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            left.add(str.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            String fun = br.readLine();

            switch(fun.split(" ")[0]) {
                case "L":
                    if(!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;

                case "D":
                    if(!right.isEmpty()) {
                        left.addLast((right.pollFirst()));
                    }
                    break;

                case "B":
                    if(!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;

                case "P":
                    char ch = fun.split(" ")[1].toCharArray()[0];
                    left.addLast(ch);
                    break;
            }

        }

        while(!left.isEmpty()) {
            sb.append(left.pollFirst());
        }

        while(!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        System.out.println(sb.toString());
        
    }

}