package study.designpattern.builder2;


public class Main {
    public static void main(String[] args) {
        User2 user2
                = User2.builder()
                .name("홍길동")
                .email("hong@scoula.org")
                .password("123456")
                .phone("010-1111-22222")
                .address("서울시")
                .sex(true)
                .age(16)
                .build();
        System.out.println(user2);
    }
}