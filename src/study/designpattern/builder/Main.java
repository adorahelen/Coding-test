package study.designpattern.builder;


//if (args[0].equals("text")) {
//        // 텍스트 문서 생성
//        } else if (args[0].equals("html")) {
//        // HTML 문서 생성
//        }
// : 기존 코드는, 명령줄 인자를 통해 real루 파일에접근
//      예를 들어, 명령어 java Main text를 입력하면 텍스트 문서가 생성되고, java Main html을 입력하면 HTML 문서가 생성됨

public class Main {
    public static void main(String[] args) {
        // Build text document
        TextBuilder textBuilder = new TextBuilder();
        Director director1 = new Director(textBuilder);
        director1.construct();
        String result = textBuilder.getTextResult();
        System.out.println(result);

        // Build HTML document
        HTMLBuilder htmlBuilder = new HTMLBuilder("Greeting.html");
        Director director2 = new Director(htmlBuilder);
        director2.construct();
        String htmlResult = htmlBuilder.getHTMLResult();
        System.out.println(htmlResult);
    }

    // 명령줄 인자를 받지 않고, 코드 내부에서 텍스트 문서와 HTML 문서를 둘 다 생성합니다.
    // 사용자가 선택할 필요 없이 프로그램을 실행하면 자동으로 두 종류의 문서가 모두 만들어집니다.
}