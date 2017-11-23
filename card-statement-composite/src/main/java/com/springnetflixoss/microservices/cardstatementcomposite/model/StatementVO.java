package com.springnetflixoss.microservices.cardstatementcomposite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by edneyroldao on 22/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementVO {

    private Long id;
    private Long cardId;
    private String operationDate;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StatementVO [id=" + id + ", cardId=" + cardId + ", operationDate=" + operationDate + ", value=" + value
                + "]";
    }

}
