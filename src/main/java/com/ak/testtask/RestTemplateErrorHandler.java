package com.ak.testtask;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                //todo handle
            }

            if (clientHttpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                //todo handle
            }
        }
    }
}
