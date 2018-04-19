package io.logicode.iologicode.config;

import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;


@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init (ChapterRepository repository) {
        return (String... args) -> {
            Stream.of(
                    Chapter.builder().name("Book of love").build(),
                    Chapter.builder().name("Book of hate").build(),
                    Chapter.builder().name("Book of indifference").build())
                    .peek(repository::save);
        };
    }
}
