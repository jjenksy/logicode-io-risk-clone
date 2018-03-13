package io.logicode.iologicode.dao;

import io.logicode.iologicode.dao.entity.Chapter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {
}

