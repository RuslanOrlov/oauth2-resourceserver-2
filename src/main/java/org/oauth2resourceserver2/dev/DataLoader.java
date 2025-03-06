package org.oauth2resourceserver2.dev;

import lombok.RequiredArgsConstructor;
import org.oauth2resourceserver2.models.Author;
import org.oauth2resourceserver2.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        authorRepository.save(Author.builder().name("Author 1").build());
        authorRepository.save(Author.builder().name("Author 2").build());
        authorRepository.save(Author.builder().name("Author 3").build());
        authorRepository.save(Author.builder().name("Author 4").build());
        authorRepository.save(Author.builder().name("Author 5").build());
    }
}
