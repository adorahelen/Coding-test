package study.designpattern.builder;

public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();
// sb에 쌓아나간다.

    @Override
    public void makeTitle(String title) {
        sb.append("==============================\n");
        sb.append("[" + title + "]\n");
        sb.append("\n");
    }

    @Override
    public void makeString(String str) {
        sb.append('*' + str + "\n");
        sb.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            sb.append("  ・" + item + "\n");
        }
        sb.append("\n");
    }

    @Override
    public void close() {
        sb.append("==============================\n");
    }

    public String getTextResult() {
        return sb.toString();
    }
}