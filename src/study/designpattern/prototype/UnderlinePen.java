package study.designpattern.prototype;

// UnderlinePen 클래스는 문자열을 출력한 뒤 밑줄을 그어주는 기능을 제공합니다.
public class UnderlinePen implements Product {
    private char ulchar;  // 밑줄에 사용할 문자

    // 생성자에서 밑줄에 사용할 문자를 받음
    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    // 주어진 문자열을 출력하고, 그 아래에 밑줄을 그려줌
    @Override
    public void use(String s) {
        int ulen = s.length();
        System.out.println(s);  // 문자열 출력
        for (int i = 0; i < ulen; i++) {
            System.out.print(ulchar);  // 밑줄 출력
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
