package study.solid;

public class YesSolid {

    //1. SRP (Single Responsibility Principle)
// 클래스 하나에 기능 3개, 클래스 3개이며 각각 기능 1개

    class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    class EmailService {
        public void sendEmail(String email, String message) {
            System.out.println("Sending email to " + email + ": " + message);
        }
    }

    class UserRepository {
        public void save(User user) {
            System.out.println("Saving user to database.");
        }
    }

/*
* User 클래스는 사용자 데이터에 대한 정보만 관리하고,
* 이메일 전송과 데이터베이스 저장 기능은 각각 EmailService와 UserRepository에서 담당하게 분리하여
* SRP를 지켰습니다.
* */

    // 2. OCP (Open/Closed Principle)
    // 새로운 도형을 추가할 때 Shape 인터페이스를 구현한 새로운 클래스를 만들면 되고, AreaCalculator 클래스는 수정할 필요가 없습니다.
    interface Shape {
        double calculateArea();
    }

    class Rectangle implements Shape {
        public int width;
        public int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    class Circle implements Shape {
        public int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    class AreaCalculator {
        public double calculate(Shape shape) {
            return shape.calculateArea();
        }
    }

    // 3. LSP (Liskov Substitution Principle)
    //LSP는 자식 클래스는 언제나 부모 클래스를 대체할 수 있어야 한다는 원칙입니다.
    class Bird {
        public void move() {
            System.out.println("Bird is moving.");
        }
    }

    class FlyingBird extends Bird {
        public void fly() {
            System.out.println("Bird is flying.");
        }
    }

    class Ostrich extends Bird {
        @Override
        public void move() {
            System.out.println("Ostrich is running.");
        }
    }
    // Bird 클래스에서 공통된 동작인 move()를 정의하고, FlyingBird에서만 fly()를 구현하여 타당하게 확장할 수 있도록 만들었습니다.


// 4. ISP (Interface Segregation Principle)
//
//ISP는 클라이언트가 자신이 사용하지 않는 메서드에 의존하지 않아야 한다는 원칙입니다.

    interface Workable {
        void work();
    }

    interface Eatable {
        void eat();
    }

    class HumanWorker implements Workable, Eatable {
        @Override
        public void work() {
            System.out.println("Human is working.");
        }

        @Override
        public void eat() {
            System.out.println("Human is eating.");
        }
    }

    class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working.");
        }
    } // 인터페이스를 Workable과 Eatable로 분리하여, 로봇은 Workable만 구현하고 불필요한 eat() 메서드를 구현하지 않게 했습니다.


// 5. DIP (Dependency Inversion Principle)
//
//DIP는 고수준 모듈이 저수준 모듈에 의존하지 않고, 둘 다 추상화된 인터페이스에 의존해야 한다는 원칙입니다.

    interface Switchable {
        void turnOn();
        void turnOff();
    }

    class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Light bulb is on.");
        }

        @Override
        public void turnOff() {
            System.out.println("Light bulb is off.");
        }
    }

    class Switch {
        private Switchable device;

        public Switch(Switchable device) {
            this.device = device;
        }

        public void operate() {
            device.turnOn();
        }
    }


}
