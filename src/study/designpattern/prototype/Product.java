package study.designpattern.prototype;

// Product 인터페이스는 '복제 가능한' 객체를 정의하는 인터페이스로 Cloneable을 상속받아 객체 복사를 가능하게 합니다.
public interface Product extends Cloneable {
    void use(String s);   // 사용 방식을 정의하는 메서드
    Product createCopy(); // 복제를 정의하는 메서드
}
// 	•	기본적으로 clone() 메소드는 **얕은 복사(shallow copy)**를 수행합니다. 이는 객체가 참조하는 다른 객체들은 복제되지 않고, 참조 값만 복사된다는 의미입니다.

/*	•	얕은 복사(Shallow Copy): 객체의 필드 값을 그대로 복사하지만, 참조형 변수는 새로운 객체를 만들지 않고 참조 값만 복사합니다. 즉, 복사된 객체와 원본 객체가 같은 객체를 참조하게 됩니다.
	•	깊은 복사(Deep Copy): 객체를 복사할 때, 참조하고 있는 객체까지 모두 복제하여, 복사된 객체가 원본 객체와 독립적인 객체를 참조하게 만듭니다.*/