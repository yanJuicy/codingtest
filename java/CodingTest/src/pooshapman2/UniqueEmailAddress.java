package pooshapman2;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {

        String[] emails = {"test.email+james@coding.com",
                            "test.e.mail+toto.jane@coding.com",
                            "testemail+tom@cod.ing.com"};

        String[] emails2 = {"a@coding.com",
                "b@coding.com",
                "c@coding.com"};
        System.out.println(solve_split(emails2));
    }

    public static int solve(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] strArray = email.split("@");
            String local = strArray[0];
            String domain = strArray[1];
            StringBuilder newLocal = new StringBuilder();
            for (int i=0; i<local.length(); i++) {
                if (local.charAt(i) == '.') continue;
                if (local.charAt(i) == '+') break;
                newLocal.append(local.charAt(i));
            }
            set.add(newLocal.toString() + "@" + domain);
        }

        return set.size();
    }

    public static int solve_split(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] strArray = email.split("@");
            String domain = strArray[1];
            String local = strArray[0].split("\\+")[0].replace(".", "");
            set.add(local + "@" + domain);
        }

        return set.size();
    }

}
