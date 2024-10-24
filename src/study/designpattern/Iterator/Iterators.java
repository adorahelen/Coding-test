package study.designpattern.Iterator;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/*왜 Iterator 패턴을 사용할까?

보통 배열이나 리스트와 같은 자료구조를 사용할 때는 for 루프나 while 루프를 써서 요소를 탐색하는데,
 Iterator 패턴은 다양한 자료구조를 일관된 방식으로 탐색할 수 있도록 도와줍니다.
  즉, 배열이든 리스트든, 내부 구조에 상관없이 요소를 순회할 수 있는 공통된 방법을 제공하는 것이 목적입니다.

  	•	BookShelf는 책장이자 컬렉션입니다.
	•	Book은 책장이 담고 있는 책들입니다.
	•	BookShelfIterator는 **책장(BookShelf)**에 있는 책들을
	    **하나씩 꺼내 올 수 있는 방법(Iterator)**을 제공합니다.

  */

// Book 클래스
class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// BookShelf 클래스
class BookShelf implements Iterable<Book> {
    private List<Book> books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new ArrayList<>(maxsize);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}

// BookShelfIterator 클래스
class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        return bookShelf.getBookAt(index++);
    }
}

// Main
public class Iterators {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("Book 1"));
        bookShelf.appendBook(new Book("Book 2"));
        bookShelf.appendBook(new Book("Book 3"));

        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println("Book name: " + book.getName());
        }
    }

    /*왜 이걸 사용해야 할까?

	•	일관성: 다양한 데이터 구조(배열, 리스트 등)와 상관없이, Iterator를 사용하면 컬렉션을 일관된 방식으로 순회할 수 있습니다.
	•	캡슐화: Iterator는 컬렉션의 내부 구조를 노출하지 않으므로, 내부가 어떻게 구현되었는지 신경 쓰지 않고 요소에 접근할 수 있습니다.

Iterator 패턴을 이해하는 핵심은 여러 가지 데이터 구조를 통일된 방식으로 순회할 수 있게 한다는 점입니다. 이 패턴을 통해 내부의 복잡한 구조에 신경 쓰지 않고, 데이터에 하나씩 접근할 수 있습니다.
    * */
}