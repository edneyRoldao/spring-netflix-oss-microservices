package com.springnetflixoss.microservices.cardstatementcomposite.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by edneyroldao on 22/11/17.
 */
@FeignClient(name = "statement-service")
public interface StatementClient extends StatementService{
}
