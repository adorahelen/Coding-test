package study.designpattern.builder;


public class HTMLBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();
    private String filename = "untitled.html";

    public HTMLBuilder(String filename) {
        this.filename = filename;
        sb.append("<!DOCTYPE html><html><head><title>" + filename + "</title></head><body>\n");
    }

    @Override
    public void makeTitle(String title) {
        sb.append("<h1>" + title + "</h1>\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>" + str + "</p>\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for (String item : items) {
            sb.append("  <li>" + item + "</li>\n");
        }
        sb.append("</ul>\n");
    }

    @Override
    public void close() {
        sb.append("</body></html>\n");
    }

    public String getHTMLResult() {
        return sb.toString();
    }
}