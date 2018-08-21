package pl.dezet.library.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.dezet.library.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findByPrincipalId(String principalId);
}
