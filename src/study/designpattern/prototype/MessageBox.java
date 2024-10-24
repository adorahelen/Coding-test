package study.designpattern.prototype;

// MessageBox 클래스는 별표(*)를 이용해 장식된 텍스트를 출력하는 기능을 제공합니다.
public class MessageBox implements Product {
    private char decochar;  // 데코레이션 문자

    // 생성자에서 데코레이션 문자를 받음
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    // 주어진 문자열을 장식해서 출력하는 메서드
    @Override
    public void use(String s) {
        int decolen = 1 + s.length() + 1;  // 양쪽에 문자 추가
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);    // 위쪽 데코레이션 출력
        }
        System.out.println();
        System.out.println(decochar + s + decochar);  // 문자열 출력
        for (int i = 0; i < decolen; i++) {
            System.out.print(decochar);    // 아래쪽 데코레이션 출력
        }
        System.out.println();
    }

    // clone 메서드를 이용해 복제본을 반환하는 메서드 (얕은 복사)
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();  // 객체를 복제
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
