package study.designpattern.prototype;

// 프로토타입 패턴, 클래스 이름을 지정하지 않고 인스턴스를 생성하고 싶을 떄

// 매니저랑, 프로덕트 : 프레임워크 역활
// 메시지 박스랑, 언더라인펜, 메인은 이름없음

//**프로토타입 패턴(Prototype Pattern)**은 객체의 복제를 통해 새로운 인스턴스를 생성하는 디자인 패턴입니다.
//        즉, 기존 객체를 복사하여 새로운 객체를 생성하므로 객체 생성 비용을 줄이고, 성능을 향상시킬 수 있습니다.
//        특히, 복잡한 객체를 새로 생성하는 비용이 클 때 유용합니다.
//
//자바에서는 Cloneable 인터페이스와 clone() 메소드를 사용하여 프로토타입 패턴을 구현합니다.
//이 패턴은 객체의 복사에 의존하기 때문에 객체의 상태를 그대로 복제할 수 있으며,
//새로운 객체를 생성하는 대신 이미 존재하는 객체를 기반으로 새로운 인스턴스를 생성할 수 있습니다.
//



// Main 클래스: 클라이언트 역할을 수행하며, 등록된 프로토타입을 복제하여 사용하는 예시
public class Main {
    public static void main(String[] args) {
        // 준비 단계: Manager를 생성하고 다양한 Product를 등록
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');  // 밑줄 '-'를 그리는 펜
        MessageBox mbox = new MessageBox('*');      // 별표 '*'로 장식하는 박스
        MessageBox sbox = new MessageBox('/');      // 슬래시 '/'로 장식하는 박스

        // 등록: Manager에 각 제품을 이름과 함께 등록
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 생성과 사용: 등록된 프로토타입을 복제하여 사용
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");  // 밑줄로 장식된 메시지 출력
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");  // '*'로 장식된 메시지 출력
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");  // '/'로 장식된 메시지 출력
    }
}
//
//코드 설명:
//
// 1.	Product 인터페이스:
//        •	Cloneable 인터페이스를 상속받아 복제 가능함을 명시하고 있습니다.
//	•	use(String s)는 복제된 객체를 사용하여 어떤 작업을 하는 메서드이고, createCopy()는 자신의 복제본을 만드는 메서드입니다.
//	2.	Manager 클래스:
//        •	다양한 Product 객체를 등록하고, 그 복사본을 생성하여 반환합니다.
//	•	등록 메서드: register(String name, Product prototype)에서 name을 기준으로 객체를 등록합니다.
//        •	생성 메서드: create(String prototypeName)는 이름을 기반으로 등록된 객체의 복제본을 생성하여 반환합니다.
//  3.	MessageBox 클래스:
//        •	입력된 메시지를 데코레이션 문자로 감싸 출력하는 기능을 합니다.
//        •	createCopy() 메서드는 **clone()**을 사용하여 복제본을 만듭니다.
//  4.	UnderlinePen 클래스:
//        •	입력된 문자열 아래에 밑줄을 그려주는 기능을 합니다.
//	•	이 클래스도 createCopy()에서 **clone()**을 통해 복제를 수행합니다.
//  5.	Main 클래스:
//        •	클라이언트 역할을 하는 부분으로, Manager에 여러 프로토타입을 등록하고, 필요할 때 복제하여 사용합니다.
//        •	복제된 객체들은 독립적으로 작동합니다.
//
//수정 및 추가 설명:
//
//        •	clone()의 사용: Product 클래스에서 Cloneable 인터페이스를 구현한 후, clone()을 사용해 복제를 합니다. 이때 복제는 **얕은 복사(shallow copy)**입니다.
//	•	createCopy()는 clone() 메서드를 호출하여 객체를 복제하고, 복제본을 반환합니다.
//	•	예제는 복제된 객체와 원본 객체를 독립적으로 사용하는 예시를 보여줍니다.
//
//프로토타입 패턴의 장점:
//
//        1.	복잡한 객체 생성 비용 절감: 객체를 복제하여 새로운 인스턴스를 생성하므로, 복잡한 객체 생성 과정을 줄일 수 있습니다.
//	2.	유연성: 기존 객체를 복사하여 다양한 형태의 객체를 쉽게 생성할 수 있습니다.
//
//단점:
//
//        1.	깊은 복사 구현의 복잡성: 만약 객체가 참조형 데이터를 가지고 있을 경우, 깊은 복사가 필요하고, 이를 직접 구현해야 합니다.
//        2.	불완전한 복사: clone() 메서드는 기본적으로 얕은 복사만 지원하므로, 참조하는 객체들까지 복사하려면 추가 작업이 필요합니다.
//
//이 예제에서는 복사와 객체 재사용을 쉽게 할 수 있는 프로토타입 패턴의 강점을 보여주고 있습니다.