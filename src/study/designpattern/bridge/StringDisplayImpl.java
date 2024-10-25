package study.designpattern.bridge;


public class StringDisplayImpl extends DisplayImpl {

    // 필드
    private String string;
    private int width;

    // 생성자
    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.length();
    }

    // 메서드
    private void printLine() {
        System.out.print("+");
        for(int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    // 구현 (메서드)
    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }
}