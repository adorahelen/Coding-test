package study.designpattern.singletone;

public class SingleTone {


    /*1. 기본 싱글톤 패턴

코드에서 작성한 기본적인 싱글톤 패턴은 매우 간단하며,
인스턴스를 미리 생성하고, 정적 메소드 getInstance()로 반환하는 방식입니다.
 이 방식은 스레드 안전하지 않다는 단점이 있습니다.
 즉, 멀티스레드 환경에서는 여러 스레드가 동시에 getInstance()를 호출할 경우,
  싱글톤 객체가 여러 번 생성될 가능성이 있습니다.*/ // <= 즉 동시성 문제라는 것이다!


//    private static SingleTone singleton = new SingleTone();
//
//    private SingleTone() {// 생성자
//        System.out.println(" 생성자에서 싱글톤 인스턴스를 하나 생성했습니다.");
//    }
//    public static SingleTone getInstance() {
//        return singleton;
//    }

 //   2. 멀티스레드 환경에서 싱글톤 패턴 (동기화 적용)
    /*
    * 멀티스레드 환경에서 안전하게 싱글톤 객체를 생성하려면 동기화(synchronization) 처리를 해야 합니다.
    * 이렇게 하면 여러 스레드가 동시에 접근할 때도 객체가 중복 생성되지 않습니다.
*/

//     private static SingleTone singleton = null;
//
//     private SingleTone() {
//         System.out.println(" 생성자에서 싱글톤 인스턴스를 하나 생성했습니다.");
//     }
//// 2.1 동기화된 메소드 (Synchronized Method)
//    // 이렇게 하면 여러 스레드가 동시에 접근할 때도 객체가 중복 생성되지 않습니다. 단 비용 증가
//     public static synchronized SingleTone getInstance() {  // 동기화 적용
//         if (singleton == null) {
//             singleton = new SingleTone();
//         }
//         return singleton;
//     }



  //   2.2 더블 체크 로킹(Double-Checked Locking) : 이중검사로 성능 문제 해결. volatile 키워드 사용을 통해 메모리 가시성 문제 해결
    // getInstance() 메소드에 이중 검사를 사용하여 성능 문제를 완화할 수 있습니다.
//  private static volatile SingleTone singleton = null; // volatile 키워드 사용
//
//    private SingleTone() {
//        System.out.println(" 생성자에서 싱글톤 인스턴스를 하나 생성했습니다.");
//    }
//
//    public static SingleTone getInstance() {
//        if (singleton == null) {
//            synchronized (SingleTone.class) {
//                if (singleton == null) {
//                    singleton = new SingleTone(); // 최초 생성 시에만 동기화
//                }
//            }
//        }
//        return singleton;
//    }



    // 3. 정적 블록을 이용한 초기화 (Static Block Initialization)
//
//    private static SingleTone singleton;
//
//        static {
//            try {
//                singleton = new SingleTone();
//            } catch (Exception e) {
//                throw new RuntimeException("싱글톤 인스턴스 생성 실패");
//            }
//        }
//
//        private SingleTone() {
//            System.out.println(" 생성자에서 싱글톤 인스턴스를 하나 생성했습니다.");
//        }
//
//        public static SingleTone getInstance() {
//            return singleton;
//        }

   // 4. Bill Pugh Singleton (내부 정적 클래스 사용)


        private SingleTone() {
            System.out.println(" 생성자에서 싱글톤 인스턴스를 하나 생성했습니다.");
        }

        // 내부 정적 클래스
        private static class Holder {
            private static final SingleTone INSTANCE123 = new SingleTone();
        }

        public static SingleTone getInstance() {
            return Holder.INSTANCE123;  // Holder 클래스가 로딩될 때 인스턴스가 생성됨
        }


    //    5. Enum을 사용한 싱글톤
    public enum SingleTone2 {
        INSTANCE;  // 유일한 인스턴스

        public void doSomething() {
            System.out.println("싱글톤 동작 중");
        }
    }

    // 사용 예시
        public static void main(String[] args) {
            SingleTone2 singleton2 = SingleTone2.INSTANCE;
            singleton2.doSomething();  // 싱글톤 메소드 호출

            SingleTone.getInstance();

        }



//    public static void main(String[] args) {
//        SingleTone.getInstance();
//
//    }

}
