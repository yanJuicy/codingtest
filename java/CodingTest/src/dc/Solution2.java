package dc;

import java.util.ArrayList;
import java.util.Stack;

public class Solution2 {

    ArrayList<String> arrayList = new ArrayList<>();
    Stack<String> st = new Stack<>();

    public String[] solution(String[] records) {

        for (String record : records) {
            String name = record.split(" ")[0];
            String cmd = record.split(" ")[1];

            if (st.isEmpty()) {
                st.push(name + " " + cmd);
                continue;
            }

            if (!st.isEmpty() && st.peek().contains(cmd)) { // 같은 명령어면 저장
                st.push(name + " " + cmd);
                continue;
            }

            if (cmd.equals("notification")) {
                // 다른 명령어면 합칠 수 있는지 확인하고 명령어를 수행한다.
                String anotherCmd = st.peek().split(" ")[1];

                String checkString = st.pop();
                String firstName = checkString.split(" ")[0];
                int cnt = 0;
                while (!st.isEmpty() && st.peek().contains(anotherCmd)) {
                    checkString = st.pop();
                    cnt++;
                }

                String checkName = checkString.split(" ")[0];
                if (cnt == 0) {
                    st.push(checkName + " " + anotherCmd);
                } else if (cnt == 1) {
                    st.push(checkName + " and " + firstName + " " + anotherCmd);
                } else {
                    st.push(checkName + " and " + cnt + " others " + anotherCmd);
                }

                arrayList.add(st.pop());
                continue;
            }

            st.push(name + " " + cmd);
        }

        String[] answer = arrayList.toArray(arrayList.toArray(new String[arrayList.size()]));
        for (int i=0; i< answer.length; i++){
            if (answer[i].contains("share"))
                answer[i] = answer[i] + "d your post";
            else
                answer[i] = answer[i] + "ed on your post";
        }
        return answer;
    }

}