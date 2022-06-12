package samgau.holding.libraryapp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBook(long id){
        return bookRepository.findById(id);
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public Long sumPrice(){
        return bookRepository.sumPrice();
    }
}
