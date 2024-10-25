//package study.designpattern.builder2;
//
//public class User {
//    private String name;
//    private String email;
//    private String password;
//    private String phone;
//    private String address;
//    private boolean sex;
//    private int age;
//    public User() {
//    }
//
//    private User(String name, String email, String password, String phone, String address, boolean sex, int age) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.phone = phone;
//        this.address = address;
//        this.sex = sex;
//        this.age = age;
//    }
//// Getter, Setter, toString 생략
//
//    public static class Builder {
//        private String name;
//        private String email;
//        private String password;
//        private String phone;
//        private String address;
//        private boolean sex;
//        private int age;
//
//        private Builder() { } // private 생성자이므로 외부에서 생성 불가
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//        public Builder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public Builder password(String password) {
//            this.password = password;
//            return this;
//        }
//        public Builder phone(String phone) {
//            this.phone = phone;
//            return this;
//        }
//        public Builder address(String address) {
//            this.address = address;
//            return this;
//        }
//        public Builder sex(boolean sex) {
//            this.sex = sex;
//            return this;
//        }
//        public Builder age(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public User build() {
//            return new User(name, email, password, phone, address, sex, age);
//        }
//    } // end of Builder
//    public static Builder builder() {
//        return new Builder(); // private 생성자 호출
//    }
//
//// 아래 코드를 작성해주지 않으면,
//// User@4617c264는 User 클래스의 기본 toString() 메서드가 호출
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", phone='" + phone + '\'' +
//                ", address='" + address + '\'' +
//                ", sex=" + sex +
//                ", age=" + age +
//                '}';
//    }
//}
