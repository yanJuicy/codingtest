package pooshapman.array2d;

import java.util.ArrayList;
import java.util.List;

public class Convert_2DArray_List {
    public static void main(String[] args) {
        int [][] A = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<List<Integer>> list = convert(A);
        System.out.println(list);

        int[][] arr2 = convert2(list);
        print(arr2);
    }

    private static List<List<Integer>> convert(int[][] a) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0; i<a.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j=0; j<a[i].length; j++) {
                temp.add(a[i][j]);
            }
            list.add(temp);
        }

        return list;
    }

    private static int[][] convert2(List<List<Integer>> list) {
        int [][] result = new int[list.size()][];

        for (int i=0; i<list.size(); i++) {

            result[i] = new int[list.get(i).size()];
            for (int j=0; j<list.get(i).size(); j++) {

                result[i][j] = list.get(i).get(j);
            }
        }

        return result;
    }

    private static void print(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
