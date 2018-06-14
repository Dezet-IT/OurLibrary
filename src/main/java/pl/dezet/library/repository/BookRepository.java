package pl.dezet.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dezet.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
