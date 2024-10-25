package study.designpattern.bridge;

public class Main {
    public static void main(String[] args) {

        Display d1 = new Display(new StringDisplayImpl("Hello, Korea."));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World."));

        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));

        d1.display();
        d2.display();

        d3.display();
        d3.multiDisplay(5);
    }
}

// 1. DisplayImpl (구현 클래스 계층의 상위 클래스)
//이 클래스는 실제 구현을 담당하는 역할을 정의합니다.
//        여기서 rawOpen(), rawPrint(), rawClose() 메서드는
//구현 클래스(스트랑 디스플에이 임플이)가 반드시 구현해야 할 메서드들입니다.


// 2. StringDisplayImpl (구현 클래스의 하위 클래스)
// 이 클래스는 DisplayImpl의 구체적인 구현 클래스입니다.
// 문자열을 출력하는 방식으로 구현되어 있으며, rawOpen(), rawPrint(), rawClose()를 구현합니다.


// 3. Display (기능 클래스 계층의 상위 클래스)
// 이 클래스는 기능을 담당하는 클래스입니다.
// open(), print(), close()는 기능에 해당하고,
// 이를 이용해 display()라는 고수준의 기능을 제공합니다.
// 내부에 DisplayImpl 인스턴스를 사용해 실제 구현을 호출합니다.


// 4. CountDisplay (기능 클래스 계층의 하위 클래스)
//Display 클래스를 상속받아 기능을 확장합니다.
// 추가적으로 multiDisplay()라는 기능을 제공하여 문자열을 여러 번 출력하는 기능을 구현합니다.


// 5. Main (클라이언트 코드)
// 	1.	DisplayImpl은 구현에 대한 인터페이스를 제공하는 추상 클래스입니다. 여기서 구체적인 구현은 StringDisplayImpl이 담당합니다.
//	2.	Display는 기능을 제공하는 클래스입니다. 구체적인 구현은 DisplayImpl 인터페이스를 통해 호출됩니다.
//	3.	CountDisplay는 Display의 기능을 확장하여 문자열을 여러 번 출력하는 multiDisplay() 메서드를 제공합니다.
//	4.	Main 클래스는 Display와 CountDisplay 객체를 생성하여 display()와 multiDisplay() 기능을 사용합니다.
