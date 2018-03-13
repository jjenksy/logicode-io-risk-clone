package io.logicode.iologicode.controller;


import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ChapterController {

    private final ChapterRepository chapterRepository;

    public ChapterController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @GetMapping("/chapters")
    public Flux<Chapter> getChapters() {
        return chapterRepository.findAll();
    }

    @GetMapping("/chapter/{id}")
    public Mono<Chapter> getFlux(@PathVariable("id") String id){
        return chapterRepository.findById(id);
    }
}
