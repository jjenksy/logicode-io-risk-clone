package io.logicode.iologicode.controller;


import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import io.logicode.iologicode.dao.entity.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class ChapterController {

    public static final String API_BASE_PATH = "/api";
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

    @PostMapping(API_BASE_PATH +"/images")
    Mono<Void> create(@RequestBody Flux<Image> images){
            return images.map(image -> {
                log.info("We will save {} soon", image);
                return image;
            }).then();
    }

}
