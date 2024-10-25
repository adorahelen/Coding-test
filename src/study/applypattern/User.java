package study.applypattern;



public class User {
    private String username;
    private String password;
    private boolean loggedIn;

    private User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false; // 초기 로그인 상태는 false
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(username, password);
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}