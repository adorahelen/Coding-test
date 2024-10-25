package study.applypattern;

public class LoginCommand implements Command {
    private User user;
    private String username;
    private String password;

    public LoginCommand(User user, String username, String password) {
        this.user = user;
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        if (user.getUsername().equals(username) && password.equals("123456")) { // 단순한 비밀번호 검증
            user.setLoggedIn(true);
            System.out.println(user.getUsername() + " 님이 로그인되었습니다.");
        } else {
            System.out.println("로그인 실패: 아이디 또는 비밀번호가 틀립니다.");
        }
    }
}

