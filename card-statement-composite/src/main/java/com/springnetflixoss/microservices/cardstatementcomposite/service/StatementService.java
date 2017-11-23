package com.springnetflixoss.microservices.cardstatementcomposite.service;

import com.springnetflixoss.microservices.cardstatementcomposite.model.StatementVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by edneyroldao on 22/11/17.
 */
public interface StatementService {

    String PREFIX = "api/";

    @GetMapping(PREFIX + "statements")
    List<StatementVO> getStatements();

    @GetMapping(PREFIX + "statement/{statementId}")
    StatementVO getStatement(@PathVariable("statementId") Long statementId);

    @GetMapping(PREFIX + "statement")
    List<StatementVO> getStatements(@RequestParam("cardId") Long cardId);

}
