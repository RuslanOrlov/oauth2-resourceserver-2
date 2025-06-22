package org.oauth2resourceserver2.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.oauth2resourceserver2.models.Author;
import org.oauth2resourceserver2.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> authors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) throws EntityNotFoundException {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(
                () -> new EntityNotFoundException("No found author with id -'" + id)
        );
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
