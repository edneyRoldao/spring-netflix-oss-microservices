package com.springnetflixoss.microservices.cardservice.api;

import com.springnetflixoss.microservices.cardservice.model.Card;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by edneyroldao on 21/11/17.
 */
@RestController
@RequestMapping("/api/")
public class CardServiceController {

    private List<Card> fakeRepo;

    @PostConstruct
    public void init() {
        fakeRepo = new ArrayList<>();
        fakeRepo.add(new Card(1l, "John Warner", String.valueOf(Math.random()).substring(0, 16),"11/20"));
        fakeRepo.add(new Card(2l, "Paul Crarte", String.valueOf(Math.random()).substring(0, 16),"09/25"));
        fakeRepo.add(new Card(3l, "Ana Hassent", String.valueOf(Math.random()).substring(0, 16),"01/19"));
        fakeRepo.add(new Card(4l, "Elena Tarin", String.valueOf(Math.random()).substring(0, 16),"06/22"));
        fakeRepo.add(new Card(5l, "Wending Qua", String.valueOf(Math.random()).substring(0, 16),"03/25"));
        fakeRepo.add(new Card(6l, "Julio Sanch", String.valueOf(Math.random()).substring(0, 16),"09/18"));
        fakeRepo.add(new Card(7l, "Adolf Bianc", String.valueOf(Math.random()).substring(0, 16),"07/22"));
    }

    @GetMapping("cards")
    public List<Card> getCards() {
        return fakeRepo;
    }

    @GetMapping("card/{cardId}")
    public Card getCard(@PathVariable Long cardId) {
        return Optional.ofNullable(
                fakeRepo
                    .stream()
                    .filter(c -> c.getId().equals(cardId))
                    .reduce(null, (u, v) -> {
                        if(u != null && v != null)
                            throw new IllegalArgumentException("More than one card found");
                        else
                            return u == null ? v : u;
                    })
        ).get();
    }

    @PostMapping(value = "new-card", headers = "Accept=application/json")
    public void createCard(@RequestBody Card newCard) {
        if(newCard != null)
            fakeRepo.add(newCard);

        System.out.println("New card passing: " + newCard);
    }

}
