package io.logicode.iologicode.config;

import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;


@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init (ChapterRepository repository) {
        return args -> {
            Flux.just(
                    Chapter.builder().name("Book of love").build(),
                    Chapter.builder().name("Book of hate").build(),
                    Chapter.builder().name("Book of indifference").build())
                    .flatMap(repository::save).subscribe(System.out::println);
        };
    }
}
