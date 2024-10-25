package study.designpattern.bridge;


public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    } // 생성자

    // 메소드 (새 기능) but 부모꺼를 호출하고 있음
    //      * 전부 위임되고 있음 (정의 되어 있지 않고 가져다 씀)
    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}