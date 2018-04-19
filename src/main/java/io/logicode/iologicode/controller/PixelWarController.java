package io.logicode.iologicode.controller;


import com.google.common.collect.Lists;
import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class PixelWarController {

    private final ChapterRepository chapterRepository;

    public PixelWarController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @RequestMapping({"/",""})
    public String getChapters(Model model) {
        List<Chapter> chapters = Lists.newArrayList(chapterRepository.findAll());
//        model.addAllAttributes(chapters);
        //todo clean this up a bit
        model.addAttribute("chapter", "Hello mate");
        return "main";
    }
//
//    @GetMapping("/chapter/{id}")
//    public Optional<Chapter> getFlux(@PathVariable("id") String id){
//        return chapterRepository.findById(id);
//    }


}
