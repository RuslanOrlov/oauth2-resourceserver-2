package org.oauth2resourceserver120250105.repositories;

import org.oauth2resourceserver120250105.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameContainsIgnoreCase(String name);
}
