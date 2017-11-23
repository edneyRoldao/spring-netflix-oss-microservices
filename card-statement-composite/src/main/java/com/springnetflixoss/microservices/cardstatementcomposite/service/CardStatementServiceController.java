package com.springnetflixoss.microservices.cardstatementcomposite.service;

import com.springnetflixoss.microservices.cardstatementcomposite.model.CardVO;
import com.springnetflixoss.microservices.cardstatementcomposite.model.StatementVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edneyroldao on 22/11/17.
 */
@RestController
@RequestMapping("/api/")
public class CardStatementServiceController {

    private CardClient cardClient;
    private StatementClient statementClient;

    /**
     * There' no magic here. I'm using constructor-based dependency injection provided by spring.
     * When a class has just one constructor, the autowired annotation is optional.
     * @param cardClient
     * @param statementClient
     */
    public CardStatementServiceController(CardClient cardClient, StatementClient statementClient) {
        this.cardClient = cardClient;
        this.statementClient = statementClient;
    }

    @GetMapping("statement-by-card")
    public ResponseEntity<Map<CardVO, List<StatementVO>>> getStatementByCardId(@RequestParam("cardId") Long cardId) {
        Map<CardVO, List<StatementVO>> response = new HashMap<>();
        response.put(cardClient.getCard(cardId), statementClient.getStatements(cardId));

        return new ResponseEntity<Map<CardVO, List<StatementVO>>>(response, HttpStatus.OK);
    }

}
