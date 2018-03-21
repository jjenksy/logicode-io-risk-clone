package io.logicode.iologicode.controller;

import io.logicode.iologicode.dao.ChapterRepository;
import io.logicode.iologicode.dao.entity.Chapter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class PixelWarControllerTest {

    private MockMvc mockMvc;

    @Mock
    ChapterRepository chapterRepository;

    @InjectMocks
    private PixelWarController pixelWarController;

    Flux<Chapter> chapterFlux;

    @Before
    public void setUp() throws Exception {

        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(pixelWarController);

        chapterFlux = Flux.empty();
        mockMvc = builder.build();
    }

    @Test
    public void getChapters() throws Exception {
        when(chapterRepository.findAll()).thenReturn(chapterFlux);
        MvcResult result = mockMvc.perform(get(PixelWarController.API_BASE_PATH+"/chapters")).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        JSONArray objectArray = new JSONArray(result.getResponse().getContentAsString());
        log.error("Object array {}", objectArray);
    }

    @Test
    public void getFlux() {
    }

    @Test
    public void create() {
    }
}