package study.designpattern.bridge;


public class Display {

    private DisplayImpl impl; // bridge 역할(위임)

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {impl.rawOpen();}
    public void print() {impl.rawPrint();}
    public void close() {impl.rawClose();}

    public final void display() {
        open();
        print();
        close();
    }
}