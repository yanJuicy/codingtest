package programmers.신규_아이디_추천;

public class Solution {

    public String solution(String new_id) {
        new_id = toLowerId(new_id);
        new_id = removeSpecialChar(new_id);
        new_id = removeContinueDot(new_id);
        new_id = removeEdgeDot(new_id);
        new_id = ifEmptyThenA(new_id);
        new_id = ifLongerThan16(new_id);
        new_id = ifShorterThan2(new_id);
        return new_id;
    }

    private String toLowerId(String id) {
        return id.toLowerCase();
    }

    private String removeSpecialChar(String id) {
        StringBuilder sb = new StringBuilder();
        char[] chars = id.toCharArray();
        for (char c : chars) {
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_'
                    || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String removeContinueDot(String id) {
        return id.replaceAll("[.]{2,}", ".");
    }

    private String removeEdgeDot(String id) {
        StringBuilder sb = new StringBuilder(id);

        while (sb.indexOf(".") == 0) {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && sb.lastIndexOf(".") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    private String ifEmptyThenA(String id) {
        if (id.equals("")) {
            return "a";
        }
        return id;
    }


    private String ifLongerThan16(String id) {
        StringBuilder sb = new StringBuilder(id);

        if (sb.length() >= 16) {
            sb = new StringBuilder(sb.substring(0, 15));
        }
        while (sb.length() > 0 && sb.lastIndexOf(".") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    private String ifShorterThan2(String id) {
        StringBuilder sb = new StringBuilder(id);
        while (sb.length() <= 2) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }
}
