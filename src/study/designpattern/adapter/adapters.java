package study.designpattern.adapter;


/*어댑터 패턴(Adapter Pattern)**은 두 개의 서로 호환되지 않는 인터페이스 간에 중간 다리 역할을 하여
 * 호환성을 제공하는 디자인 패턴입니다.*/

/*
어댑터 패턴은 크게 두 가지 방식으로 구현할 수 있습니다:

	1.	상속을 이용한 어댑터
	2.	위임을 이용한 어댑터

* */


// Target 인터페이스
interface Target {
    void request();
}

// Adaptee 클래스 (호환되지 않는 기존 클래스)
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee: specificRequest 실행됨");
    }
}

// Adapter 클래스 (상속을 사용하여 Adaptee와 Target을 연결)
class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        // Adaptee의 메서드를 사용해 클라이언트의 요청을 처리
        specificRequest();
    }
}

// 위임을 이용한 어댑터 패턴
class ObjectAdapter implements Target {
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// 클라이언트 코드
public class adapters {
    public static void main(String[] args) {
        // 상속을 사용한 어댑터
        Target target1 = new Adapter();
        target1.request();  // Adaptee의 specificRequest가 호출됨

        // 위임을 사용한 어댑터
        Adaptee adaptee = new Adaptee();
        Target target2 = new ObjectAdapter(adaptee);
        target2.request();  // Adaptee의 specificRequest가 호출됨
    }

    /*
    1.	상속을 이용한 어댑터: Adapter 클래스가 Adaptee를 상속받아 Target 인터페이스를 구현하고 있습니다.
	2.	위임을 이용한 어댑터: ObjectAdapter 클래스는 Adaptee 객체를 포함하고 있으며, Target 인터페이스를 구현합니다.
	3.	Main 클래스는 두 가지 방법을 사용하여 어댑터 패턴을 실행하는 클라이언트 역할을 합니다.
    * */
}
