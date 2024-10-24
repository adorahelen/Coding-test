package study.designpattern.homework1024;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties();  // FileProperties 객체 생성


        // 절대 경로 vs 상대 경로(상대경로 승 : 절대 경로는 로컬 기준이라 배포시 무용지물)
        // IDE 내부에서 상대 경로를 사용하려면, 일반적으로 Path From Content Root를 사용하는 것이 좋습니다.
        // 이 경로는 프로젝트의 루트 디렉터리에서 시작하며, 다른 개발자들과 함께 프로젝트를 공유할 때도 시스템 독립적으로 사용할 수 있기 때문입니다.

        // 요약 : 상대경로 써라, Path From Content Root 써라
        try {
            // 경로를 명시하여 파일 읽기
//            f.readFromFile("resources/file.txt");  // 상대 경로
            f.readFromFile("src/study/designpattern/homework1024/file.txt"); // 상대경로
            // 속성 값 설정
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            // 경로를 명시하여 파일 쓰기
            f.writeToFile("src/study/designpattern/homework1024/file.txt"); // 상대경로
            System.out.println("newfile.txt 파일이 생성되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}