package programmers.warpUp;

import java.util.ArrayList;
import java.util.List;

public class CodeImplementTip {

    public static void main(String[] args) {
        System.out.println(totalPrice(4, 50));

        // 재네릭을 사용하지 않아, 호출하면 런타임 오류가 발생할 리스트 객체
        List list = new ArrayList();
        list.add(10);
        list.add("abc");
        // Exception in thread "main" java.lang.ClassCastException:
        // 재네릭을 명시하지 않으면, 이렇게 run 을 시켜야지 오류를 파악 할 수 있음
//        int sum1 = (int)list.get(0) + (int)list.get(1);

        List<Integer> genericList = new ArrayList();
        genericList.add(1);
        genericList.add(2);
//        genericList.add("3");
        // 빌드가 안되도록, 빨간 줄이 그어짐 => 재네릭을 통해 명시를 해 뒀기에 가능함
        int sum2 = genericList.get(0) + genericList.get(1);
        System.out.println(sum2);

    }

    // 1. 조기 반환 구문, if 인 경우 빨리 하고 끝
    static int totalPrice(int quantitiy, int price) {
        int total = quantitiy * price;
        if (total > 100)
            return (int)(total * 0.9);
        return total;
    }

    // 2. 보호 구문 : 본격적인 로직 전, 예외 처리 코드를 추가하는 기법
    static double calculateAverage(List<Integer> numbers) {
        if (numbers == null) return 0;
        if (numbers.isEmpty()) return 0;
        int total = numbers.stream().mapToInt(i -> i).sum(); // 기능 구현
        return (double)total / numbers.size();
    }

    // 3.제네릭 사용 : 빌드 레벨에서 타입을 체크하여 안정성을 제공 & 형번환 생략
//    List<Integer> todayis1023 = new ArrayList<>();
//    todayis1023.add(10);
//    	•	클래스 안에 메서드(함수)를 정의하는 것은 정상적인 방법입니다.
//            하지만 메서드 바깥에서 실행 코드를 작성하는 것은 허용되지 않습니다.
//                모든 실행 코드(변수 초기화, 메서드 호출 등)는 생성자나 다른 메서드 안에서 작성해야 합니다.

}
