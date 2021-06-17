package pooshapman.string;

public class String_palindrom {

    int start, end;

    public String solve(String s) {
        int len = s.length();
        if (len < 2) return s;

        for (int i=0; i<len-1; i++) {
            findString(s, i, i);    // odd
            findString(s, i, i+1);  // even
        }

        return s.substring(start, start+end);
    }

    private void findString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (end < right - left - 1) {
            start = left + 1;
            end = right - left - 1;
        }
    }


    public static void main(String[] args) {
        String_palindrom a = new String_palindrom();
        String s = "bananas";

        System.out.println(a.solve(s));
//			System.out.println(a.solve(s));
    }

}
