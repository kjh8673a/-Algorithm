import java.io.*;
import java.util.*;

public class Main {

    static class Member {
        int idx;
        int age;
        String name;

        public Member(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Member[] members = new Member[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(i, age, name);
        }
        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.age == o2.age) {
                    return Integer.compare(o1.idx, o2.idx);
                }
                return Integer.compare(o1.age, o2.age);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(members[i].age + " " + members[i].name).append("\n");
        }

        System.out.println(sb.toString());
    }

}