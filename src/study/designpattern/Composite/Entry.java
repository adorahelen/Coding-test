package study.designpattern.Composite;

public abstract class Entry {

    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        printList("");
    }

    // prefix를 앞에 붙여서 목록을 표시
    protected abstract void printList(String prefix);

    // 문자열 표시
    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}