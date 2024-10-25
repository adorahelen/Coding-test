package study.applypattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 사용자 빌더를 사용하여 사용자 생성
        User user = new User.Builder()
                .username("rkdals@naver.com")
                .password("123456")
                .build();

        // 세션에 사용자 등록
        SessionManager.getInstance().setCurrentUser(user);

        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("명령어를 입력하세요 (login/logout/exit): ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("login")) {
                System.out.print("아이디를 입력하세요: ");
                String username = scanner.nextLine();
                System.out.print("비밀번호를 입력하세요: ");
                String password = scanner.nextLine();

                // 로그인 명령을 설정하고 실행
                invoker.setCommand(new LoginCommand(user, username, password));
                invoker.invoke();

            } else if (command.equalsIgnoreCase("logout")) {
                // 로그아웃 명령을 설정하고 실행
                invoker.setCommand(new LogoutCommand(user));
                invoker.invoke();

            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 명령어입니다.");
            }
        }

        scanner.close();
    }
}

/*실행 흐름:

	1.	Main 클래스에서 사용자 정보를 빌더 패턴을 사용해 생성합니다.
	2.	SessionManager를 통해 전역적으로 사용자 세션을 관리합니다.
	3.	Invoker는 LoginCommand 또는 LogoutCommand를 실행합니다.
	4.	사용자가 로그인하면 세션에 저장되고, 로그아웃하면 세션에서 로그아웃됩니다.

요약:

	•	Builder 패턴은 User 객체 생성을 캡슐화하여 직관적이고 유연하게 만듭니다.
	•	Command 패턴을 통해 로그인/로그아웃 동작을 캡슐화하고 쉽게 관리할 수 있도록 합니다.
	•	싱글톤 패턴으로 전역적인 사용자 세션을 관리합니다.

이 구현을 통해 프레임워크 없이도 로그인/로그아웃 시스템을 여러 디자인 패턴을 사용하여 구조적으로 만들 수 있습니다.
* */