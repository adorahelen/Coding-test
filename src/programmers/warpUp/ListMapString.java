package programmers.warpUp;

import java.util.ArrayList;
import java.util.HashMap;

public class ListMapString {

    ArrayList<Integer> list;
    public void list(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list.get(2));
    }

    HashMap<String, Integer> map = new HashMap<>();
    public void map() {
        map.put("apple" , 1);
        map.put("orange1" , 2);
        map.put("banana" , 3);
        map.put("apple2" , 4);
        map.put("orange" , 5);

        System.out.println(map.get("apple2"));

        String key = "rezero3";
        if (map.containsKey(key)) {
            int value = map.get(key);
            System.out.println(key + " = " + value);
        }
        else {
            System.out.println(key + " doesn't exist");
        }

        map.remove("apple");
        System.out.println(map);

    }

    public static void main(String[] args) {
//        new List();
        new ListMapString().list();
        new ListMapString().map();
        // 생성자 호출 방식 & 메서드 호출 방식

        String Bleach = "Hello ichigo!";
        Bleach = Bleach.replace("l", "Ooooooooo!");
        System.out.println(Bleach);

        String s = "abc";
        System.out.println(System.identityHashCode(s));
        s += "def";
        System.out.println(System.identityHashCode(s));
        System.out.println(s);

        long start = System.currentTimeMillis();
        String ss = "";
        for (int j = 1; j <= 100000; j++){

            ss += j;
        }

        long end = System.currentTimeMillis();
        System.out.println(((end - start) / 1000.0) + "s");

//        long start2 = System.currentTimeMillis();
//        StringBuilder sb = new StringBuilder();
//        for (int j = 1; j <= 1000000; j++){
//            sb.append(j);
//        }
//        long end2 = System.currentTimeMillis();
//        System.out.println(((end - start) / 1000.0) + "s");

        long start2 = System.currentTimeMillis();

        StringBuilder sss = new StringBuilder();
//        String ss = "";
        for (int j = 1; j <= 1000000; j++){
            sss.append(j);
            // 1000000000 => Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

//            ss += j;

        }

        long end2 = System.currentTimeMillis();
        System.out.println(((end - start) / 1000.0) + "s");


    }




}




