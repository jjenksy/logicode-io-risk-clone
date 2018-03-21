package io.logicode.iologicode.controller;


import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import io.logicode.iologicode.dao.entity.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(PixelWarController.API_BASE_PATH)
@Slf4j
public class PixelWarController {

    public static final String API_BASE_PATH = "/pixel_war";
    private final ChapterRepository chapterRepository;

    public PixelWarController(ChapterRepository chapterRepository) {
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

    @PostMapping("/images")
    Mono<Void> create(@RequestBody Flux<Image> images){
            return images.map(image -> {
                log.info("We will save {} soon", image);
                return image;
            }).then();
    }

}
