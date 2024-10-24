package study.solid;

public class NoSolid {

    //1. SRP (Single Responsibility Principle)

    class NoUser {
        private String name;
        private String email;

        public NoUser(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public void sendEmail(String message) {
            System.out.println("Sending email to " + email + ": " + message);
        }

        public void saveToDatabase() {
            System.out.println("Saving user to database.");
        }
    }


    // 2. OCP (Open/Closed Principle)
    // 여기서 새로운 도형을 추가할 때마다 AreaCalculator 클래스를 수정해야 하므로 OCP를 지키지 않았습니다.
    class Rectangle {
        public int width;
        public int height;
    }

    class Circle {
        public int radius;
    }

    class AreaCalculator {
        public double calculate(Object shape) {
            if (shape instanceof YesSolid.Rectangle) {
                YesSolid.Rectangle rectangle = (YesSolid.Rectangle) shape;
                return rectangle.width * rectangle.height;
            } else if (shape instanceof YesSolid.Circle) {
                YesSolid.Circle circle = (YesSolid.Circle) shape;
                return Math.PI * circle.radius * circle.radius;
            }
            return 0;
        }
    }

    // 3. LSP (Liskov Substitution Principle)
    //LSP는 자식 클래스는 언제나 부모 클래스를 대체할 수 있어야 한다는 원칙입니다

    class Bird {
        public void fly() {
            System.out.println("Bird is flying.");
        }
    }

    class Ostrich extends Bird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Ostrich can't fly.");
        }

    }

    // 4. ISP (Interface Segregation Principle)
    //
    //ISP는 클라이언트가 자신이 사용하지 않는 메서드에 의존하지 않아야 한다는 원칙입니다.


    interface Worker {
        void work();
        void eat();
    }

    class Robot implements Worker {
        @Override
        public void work() {
            System.out.println("Robot is working.");
        }

        @Override
        public void eat() {
            // 로봇은 먹지 않음 <= 필요 없는게 들어감
        }
    }


    // 5. DIP (Dependency Inversion Principle)
    //
    //DIP는 고수준 모듈이 저수준 모듈에 의존하지 않고, 둘 다 추상화된 인터페이스에 의존해야 한다는 원칙입니다.

    class LightBulb {
        public void turnOn() {
            System.out.println("Light bulb is on.");
        }

        public void turnOff() {
            System.out.println("Light bulb is off.");
        }
    }

    class Switch {
        private LightBulb lightBulb;

        public Switch(LightBulb lightBulb) {
            this.lightBulb = lightBulb;
        }

        public void operate() {
            lightBulb.turnOn();
        }
    }

}
