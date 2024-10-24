package study.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

// Manager 클래스는 여러 가지 'Product'를 등록하고, 이를 필요할 때 복제하여 반환하는 역할을 합니다.
public class Manager {
    private Map<String, Product> showcase = new HashMap<>();  // 등록된 'Product'를 저장할 공간

    // Product를 이름과 함께 등록
    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    // 등록된 Product를 이름으로 찾아서 복제
    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);
        return p.createCopy();  // 복제된 객체 반환
    }
}
