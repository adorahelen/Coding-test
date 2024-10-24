package programmers.ch1Array;

import java.util.ArrayList;
import java.util.Arrays;

public class WarpUp {



    public static void main(String[] args) {
        int[]arr0 = {0,0,0,0,0,0,0,0,0};
        int[]ar1 = new int[6];
        int[][]arr2 = {{1,2}, {1,2}};

//        System.out.println(arr0.toString());
        System.out.println(Arrays.toString(arr0));
        System.out.println(Arrays.toString(ar1));
        // 1차원 배열은 이렇게 출력하거나 for
        System.out.println(Arrays.deepToString(arr2));
        // 2차원 배열 이상 부터는, 딥 투 스트링으로

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(Arrays.toString(list2.toArray()));

        //

        System.out.println(Arrays.toString(list.toArray()));
        ArrayList<Integer> list3 = new ArrayList<>(list);
        System.out.println(Arrays.toString(list3.toArray()));




    }
}
