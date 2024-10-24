package study.designpattern.template;


/*템플릿 메소드 패턴(Template Method Pattern)
알고리즘의 구조를 정의하고, 그 구조 내에서 일부 단계는 하위 클래스에서 구현하도록 하는 디자인 패턴입니다.
즉, 알고리즘의 뼈대는 상위 클래스에서 정의하고, 세부 구현은 하위 클래스에서 담당하도록 하는 구조를 만듭니다.
*
	1.	**상위 클래스(추상 클래스)**가 알고리즘의 기본 구조를 정의합니다.
	2.	하위 클래스는 상위 클래스에서 정의된 알고리즘의 구체적인 단계를 오버라이드(재정의)하여 자신의 방식대로 구현합니다.
	3.	상위 클래스는 알고리즘의 변하지 않는 부분을 담당하고, 하위 클래스는 변경 가능한 부분을 구현합니다.

*/

// 추상 클래스(상위 클래스) - 템플릿 메소드를 정의
abstract class Beverage {
    // 템플릿 메소드 (알고리즘의 뼈대)
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // 변하지 않는 부분 (상위 클래스에서 공통 구현)
    private void boilWater() {
        System.out.println("물 끓이는 중...");
    }

    private void pourInCup() {
        System.out.println("컵에 따르는 중...");
    }

    // 하위 클래스에서 구현해야 하는 부분 (추상 메소드)
    protected abstract void brew();           // 음료를 우려내는 과정
    protected abstract void addCondiments();  // 첨가물을 추가하는 과정
}


// ConcreteClass - 커피 만드는 클래스(하위 클래스1)
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("커피를 우려내는 중...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("설탕과 우유를 추가하는 중...");
    }
}

// ConcreteClass - 차 만드는 클래스(하위 클래스2)
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("차를 우려내는 중...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("레몬을 추가하는 중...");
    }
}
// 스프링, 스프링 부트의 방식이지만 그들은 "상속"을 쓰지않고 @어노테이션으로 구현했다.
//      * 템플릿 메소드 방식으로

// 클라이언트 코드
public class TemplateMethod {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();  // 커피 만드는 과정 실행

        System.out.println();

        Beverage tea = new Tea();
        tea.prepareRecipe();  // 차 만드는 과정 실행
    }
}
