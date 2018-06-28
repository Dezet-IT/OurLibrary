package pl.dezet.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dezet.library.model.BookDetails;

public interface BookDetailsRepository extends JpaRepository<BookDetails,Long> {
}
