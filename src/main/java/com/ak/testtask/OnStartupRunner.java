package com.ak.testtask;

import com.ak.testtask.model.Symbol;
import com.ak.testtask.repositories.SymbolRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class OnStartupRunner implements CommandLineRunner {
    private RestTemplate restTemplate;
    private SymbolRepository symbolRepository;

    //todo make as properties
    private String stockUrl = "https://sandbox.iexapis.com/stable/stock/";
    private String symbolsInfoUrl = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private String token = "Tpk_ee567917a6b640bb8602834c9d30e571";
    //in seconds
    private long executionDelay = 5;

    @Autowired
    public OnStartupRunner(RestTemplate restTemplate, SymbolRepository symbolRepository) {
        this.restTemplate = restTemplate;
        this.symbolRepository = symbolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
//            saveSymbolsToDatabase();
            Thread.sleep(executionDelay * 1000);
        }
    }

    //todo refactor
    private void saveSymbolsToDatabase() {
        List<String> enabledSymbols = getEnabledSymbols();

        String requestUrl;
        Symbol symbol;

        for (String enabledSymbol : enabledSymbols) {
            requestUrl = stockUrl + enabledSymbol + "/quote?token=" + token;

            try {
                symbol = restTemplate.getForObject(requestUrl, Symbol.class);
                if (symbol != null) {
                    //todo m/b replace with custom method - "saveList"
                    symbolRepository.save(symbol);
                }

            } catch (HttpClientErrorException.NotFound | HttpClientErrorException.BadRequest e) {
                //todo add log error or something else
            }
        }
    }

    //todo refactor
    private List<String> getEnabledSymbols() {
        JsonNode responseNode = restTemplate.getForObject(symbolsInfoUrl, JsonNode.class);
        List<String> enabledSymbols = new ArrayList<>();

        if (responseNode == null) {
            return Collections.emptyList();
        }

        for (JsonNode element : responseNode) {
            if (element != null && element.get("isEnabled").asBoolean()) {
                enabledSymbols.add(element.get("symbol").asText());
            }
        }
        return enabledSymbols;
    }

}
