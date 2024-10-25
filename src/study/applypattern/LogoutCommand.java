package study.applypattern;

public class LogoutCommand implements Command {
    private User user;

    public LogoutCommand(User user) {
        this.user = user;
    }

    @Override
    public void execute() {
        if (user.isLoggedIn()) {
            user.setLoggedIn(false);
            System.out.println(user.getUsername() + " 님이 로그아웃되었습니다.");
        } else {
            System.out.println("로그아웃 실패: 사용자가 로그인되어 있지 않습니다.");
        }
    }
}
