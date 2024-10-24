package study.designpattern.factory;

/*객체 생성의 책임을 서브클래스로 넘기는 방식으로 객체 생성을 캡슐화하는 디자인 패턴입니다.
즉, 객체를 생성하는 코드를 직접 작성하지 않고, 서브클래스에서 필요한 객체를 생성하도록 위임하는 방식입니다.


	1.	상위 클래스는 객체 생성 방식(메소드)을 정의하지만, 실제로 어떤 객체를 생성할지는 하위 클래스가 결정합니다.
	2.	객체 생성의 로직을 캡슐화하여 클라이언트 코드가 생성 과정과 구체적인 객체 타입에 의존하지 않도록 합니다.
	3.	이 패턴을 사용하면 객체 생성 시 확장성을 제공하면서도, 기존 코드를 수정하지 않고도 새로운 객체를 추가할 수 있습니다.

 	•	Product: 생성될 객체의 인터페이스 또는 추상 클래스.
	•	ConcreteProduct: Product의 구체적인 구현체.
	•	Creator: 객체를 생성하는 팩토리 메소드를 정의하는 클래스. 실제로 객체를 생성하는 책임은 하위 클래스에 있음.
	•	ConcreteCreator: Creator 클래스를 상속하여 구체적인 객체 생성 방법을 구현하는 클래스.

 */


// Product: 동물 인터페이스
interface Animal {
    void makeSound();
}

// ConcreteProduct: 개 클래스
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

// ConcreteProduct: 고양이 클래스
class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

// Creator: 동물 팩토리 클래스
abstract class AnimalFactory {
    // 팩토리 메소드: 구체적인 동물을 생성하는 책임은 하위 클래스에게 넘김
    public abstract Animal createAnimal();

    // 공통 로직을 포함하는 메소드
    public void makeAnimalSound() {
        Animal animal = createAnimal();
        animal.makeSound();
    }
}

// ConcreteCreator: 개를 생성하는 팩토리 클래스
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();  // 구체적인 개 객체 생성
    }
}

// ConcreteCreator: 고양이를 생성하는 팩토리 클래스
class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();  // 구체적인 고양이 객체 생성
    }
}

// 클라이언트 코드
public class FactoryMethod {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        dogFactory.makeAnimalSound();  // "멍멍"

        AnimalFactory catFactory = new CatFactory();
        catFactory.makeAnimalSound();  // "야옹"
    }
}