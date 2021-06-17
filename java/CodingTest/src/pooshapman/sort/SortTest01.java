package pooshapman.sort;

public class SortTest01 {
    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1";

        System.out.println(solve(version1, version2));
    }

    private static int solve(String a, String b) {
        String[] v1 = a.split("\\.");
        String[] v2 = b.split("\\.");

        int length = Math.max(v1.length, v2.length);

        for (int i=0; i<length; i++) {
            Integer n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            int cmp =  n1.compareTo(n2);
            if (cmp != 0) return cmp;
        }


        return 0;
    }

}
