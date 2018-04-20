package io.logicode.iologicode.config;

import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init (ChapterRepository repository) {
        return (String... args) -> {
            repository.save(Chapter.builder().name("Book of love").build());
            repository.save(Chapter.builder().name("Book of hate").build());
            repository.save(Chapter.builder().name("Book of indifference").build());
            repository.save(Chapter.builder().name("Book of love2").build());
            repository.save(Chapter.builder().name("Book of hate2").build());
            repository.save(Chapter.builder().name("Book of indifference2").build());
            repository.save(Chapter.builder().name("Book of love3").build());
            repository.save(Chapter.builder().name("Book of hate3").build());
            repository.save(Chapter.builder().name("Book of indifference3").build());
            repository.save(Chapter.builder().name("Book of love4").build());
            repository.save(Chapter.builder().name("Book of hate5").build());
            repository.save(Chapter.builder().name("Book of indifference4").build());
            repository.save(Chapter.builder().name("Book of love6").build());
            repository.save(Chapter.builder().name("Book of hate7").build());
            repository.save(Chapter.builder().name("Book of indifference5").build());
        };
    }
}
