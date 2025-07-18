package africa.semicolon.data.repositories;

import africa.semicolon.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntriesRepository extends MongoRepository<Entry, String> {
    boolean existsByTitle(String title);
    Optional<Entry> findByTitle(String title);

}
