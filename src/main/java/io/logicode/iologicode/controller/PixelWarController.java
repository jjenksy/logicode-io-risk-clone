package io.logicode.iologicode.controller;


import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class PixelWarController {

    private final ChapterRepository chapterRepository;

    public PixelWarController(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    @RequestMapping({"/",""})
    public String getChapters(Model model, @RequestParam(defaultValue = "0") int page) {
        //retrieve all the paged data from the database
        model.addAttribute("data",  chapterRepository.findAll(PageRequest.of(page, 4)));
        model.addAttribute("current_page", page);
        return "index";
    }


    //save the request and redirect home
    @PostMapping("/save")
    public String save(Chapter chapter){
        chapterRepository.save(chapter);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String delete(Integer id){
        chapterRepository.deleteById(id);
        return "redirect:/";
    }
//
//    @GetMapping("/chapter/{id}")
//    public Optional<Chapter> getFlux(@PathVariable("id") String id){
//        return chapterRepository.findById(id);
//    }


}
