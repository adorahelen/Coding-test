package study.designpattern.builder;


public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 문서를 만든느 메서드
    public void construct() {
        builder.makeTitle("Greeting : 일반적인 인사 ");
        builder.makeString("Morning to Noon");
        builder.makeItems(new String[]{
                "Good morning.",
                "Hello.",
        });
        builder.makeString("Evening : 시간대별 인사 ");
        builder.makeItems(new String[]{
                "Good evening.",
                "Good night.",
                "Goodbye.",
        });
        builder.close();
    }
}