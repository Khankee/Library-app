package samgau.holding.libraryapp.book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(value = "SELECT sum(price) FROM Book", nativeQuery = true)
    Long sumPrice();
}
