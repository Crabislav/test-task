package com.ak.testtask;

import com.ak.testtask.model.Symbol;
import com.ak.testtask.repositories.SymbolRepository;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class OnStartupRunner implements CommandLineRunner {
    private RestTemplate restTemplate;
    private SymbolRepository symbolRepository;

    //todo make as properties
    private String stockUrl = "https://sandbox.iexapis.com/stable/stock/";
    private String token = "Tpk_ee567917a6b640bb8602834c9d30e571";
    private String symbolsInfoUrl = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=" + token;
    //in seconds
    private long executionDelay = 10;

    @Autowired
    public OnStartupRunner(RestTemplate restTemplate, SymbolRepository symbolRepository) {
        this.restTemplate = restTemplate;
        this.symbolRepository = symbolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            saveSymbolsToDatabase();
            System.out.println("Top highest value stocks\n" +
                    symbolRepository.findTopHighestValueStocks());
            System.out.println("Top companies by income\n" +
                    symbolRepository.findTopRecentWithGreatestIncome());
            Thread.sleep(executionDelay * 1000);
        }
    }

    private void saveSymbolsToDatabase() {
        getEnabledSymbols().forEach(symbolName -> {
            String requestUrl = stockUrl + symbolName + "/quote?token=" + token;
            Symbol symbol = restTemplate.getForObject(requestUrl, Symbol.class);
            Optional.ofNullable(symbol)
                    .ifPresent(s -> symbolRepository.save(s));
        });
    }

    private List<String> getEnabledSymbols() {
        ArrayNode responseNode = restTemplate.getForObject(symbolsInfoUrl, ArrayNode.class);

        if (responseNode == null) {
            return Collections.emptyList();
        }

        return StreamSupport.stream(responseNode.spliterator(), false)
                .filter(element -> element.get("isEnabled").asBoolean())
                .map(element -> element.get("symbol").asText())
                .limit(5) //todo remove limit
                .collect(Collectors.toList());
    }

}
