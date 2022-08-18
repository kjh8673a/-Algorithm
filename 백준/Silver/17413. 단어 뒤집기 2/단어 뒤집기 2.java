import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<String> que = new LinkedList<>();

        String str = br.readLine();
        boolean inTag = false;
        String goQ = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '<') {
                if(goQ != "") {
                    que.offer(goQ);
                    goQ = "";
                }
                inTag = true;
                goQ += ch;
            }else if(ch == '>') {
                goQ += ch;
                que.offer(goQ);
                goQ = "";
                inTag = false;
            }else if(ch == ' ') {
                if(!inTag && goQ != "") {
                    que.offer(goQ);
                    goQ = "";
                }
                goQ += ch;
            }else if(i == str.length()-1) {
                goQ += ch;
                que.offer(goQ);
            }else {
                if(!inTag && goQ.equals(" ")) {
                    que.offer(goQ);
                    goQ = "";
                }
                goQ += ch;
            }
        }

        for(int i = 0; i < que.size(); i++) {
            String now = que.poll();
            String after = "";
            if(now.startsWith("<") || now.startsWith(" ")) {
                que.offer(now);
            }else {
                for(int j = now.length()-1; j >= 0; j--) {
                    after += now.charAt(j);
                }
                que.offer(after);
            }
            
        }

        while(!que.isEmpty()) {
            sb.append(que.poll());
        }

        System.out.println(sb.toString());
    }

}