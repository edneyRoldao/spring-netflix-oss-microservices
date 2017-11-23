package com.springnetflixoss.microservices.cardstatementcomposite.service;

import com.springnetflixoss.microservices.cardstatementcomposite.model.CardVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by edneyroldao on 22/11/17.
 */
public interface CardService {

    String PREFIX = "api/";

    @GetMapping(PREFIX + "cards")
    List<CardVO> getCards();

    @GetMapping(PREFIX + "card/{cardId}")
    CardVO getCard(@PathVariable("cardId") Long cardId);

    @PostMapping(value = PREFIX + "new-card", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void createCard(@RequestBody CardVO card);

}
