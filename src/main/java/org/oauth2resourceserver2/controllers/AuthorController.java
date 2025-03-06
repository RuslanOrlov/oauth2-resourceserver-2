package org.oauth2resourceserver2.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.oauth2resourceserver2.models.Author;
import org.oauth2resourceserver2.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) throws EntityNotFoundException {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElseThrow(
                () -> new EntityNotFoundException("No found author with id -'" + id)
        );
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
