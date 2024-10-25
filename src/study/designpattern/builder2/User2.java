package study.designpattern.builder2;

public class User2 {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean sex;
    private int age;

    // 기본 생성자 제거 후 만든 생성자(필드 받는)
    private User2(String name, String email, String password, String phone, String address, boolean sex, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

// 클래스(유저2) 내 클래스(빌더)
    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private boolean sex;
        private int age;

        private Builder() { } // 외부에서 생성 불가
// private Builder()로 직접 생성하는 것을 막고, (32번 라인)
// public static Builder builder() 메서드(77번 라인)를 통해 Builder 객체를 생성하는 안전한 방법을 제공

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder sex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public User2 build() {
            return new User2(name, email, password, phone, address, sex, age);
        }
    }



// 메서드 1
    // 빌더 객체 "생성 제공 메서드" in User2 Class
    public static Builder builder() {
        //private Builder()로 직접 생성하는 것을 막고,
        // public static Builder builder() 메서드를 통해 Builder 객체를 생성하는 안전한 방법을 제공
        return new Builder(); // Builder 객체 생성
    }


// 메서드 2
    // 투 스트링 "메서드" in User2 Class
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}