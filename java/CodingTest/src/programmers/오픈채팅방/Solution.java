package programmers.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList<String> uidList = new ArrayList<>();
        ArrayList<String> enterList = new ArrayList<>();

        for (String str : record) {
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            String cmd = stringTokenizer.nextToken();
            String uid = stringTokenizer.nextToken();
            String nickname = null;

            if (!cmd.equals("Leave"))
                nickname = stringTokenizer.nextToken();

            switch (cmd) {
                case "Enter":
                    hashMap.put(uid, nickname);
                    uidList.add(uid);
                    enterList.add("님이 들어왔습니다.");
                    break;
                case "Change":
                    hashMap.put(uid, nickname);
                    break;
                case "Leave":
                    uidList.add(uid);
                    enterList.add("님이 나갔습니다.");
                    break;
                default:
                    break;
            }
        }

        ArrayList<String> resultList = new ArrayList<>();

        for (int i=0; i<uidList.size(); i++) {
            resultList.add(hashMap.get(uidList.get(i)) + enterList.get(i));
        }

        String[] answer = resultList.toArray(new String[resultList.size()]);
        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(new String[]{"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"});

    }
}
