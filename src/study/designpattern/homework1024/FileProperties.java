package study.designpattern.homework1024;

import java.io.*;
import java.util.Properties;

public class FileProperties implements FileIO {
    private Properties properties;

    public FileProperties() {
        properties = new Properties();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            properties.load(reader);  // 파일에서 속성 로드
        }
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            properties.store(writer, "written by FileProperties");  // 파일에 속성 저장
        }
    }

    @Override
    public void setValue(String key, String value) {
        properties.setProperty(key, value);  // 속성 값 설정
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);  // 속성 값 가져오기
    }
}