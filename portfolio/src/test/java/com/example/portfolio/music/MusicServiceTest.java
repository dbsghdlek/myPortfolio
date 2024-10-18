package com.example.portfolio.music;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class MusicServiceTest {

    @Test
    public void apiTestByRestTemplate(){
        StringBuilder stb = new StringBuilder("http://www.maniadb.com/api/search/bts/?sr=artist&display=10&key=example&v=0.5");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity(new HttpHeaders());
        String method = "GET";
        ResponseEntity<String> exchange;

        if(method.equals("GET")){
            exchange = restTemplate.exchange(stb.toString(), HttpMethod.GET, entity, String.class);
        } else if (method.equals("POST")) {
            String requestBody = "{\"key 값\": \" value 값\"}";
            HttpEntity postEntity = new HttpEntity<>(requestBody, new HttpHeaders());
            exchange = restTemplate.exchange(stb.toString(), HttpMethod.POST, entity, String.class);
        }else {
            exchange = null;
        }

        System.out.println("exchange = " + exchange);
    }

    @Test
    public void apiTestByURLConnection(){
        StringBuilder stb = new StringBuilder("http://www.maniadb.com/api/search/bts/?sr=artist&display=10&key=example&v=0.5");
        String method = "GET";

        URI uri;
        try {
            uri = new URI(stb.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String response = new String();

        try {
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod(method);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            response = br.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("response = " + response);
    }

    @Test
    public void apiTestWebClient(){
        StringBuilder stb = new StringBuilder("http://www.maniadb.com/api/search/bts/?sr=artist&display=10&key=example&v=0.5");

        WebClient webClient = WebClient.builder()
                .baseUrl(stb.toString())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // GET 요청
        Mono<String> getResponse = webClient.get()
                                    .retrieve()
                                    .bodyToMono(String.class);

        getResponse.subscribe(response ->{
            System.out.println("GET Response: " + response);
        }, error ->{
            System.err.println("Error : "+ error.getMessage());
        });

        String requestBody = "{\"key 값\": \" value 값\"}";

        // POST 요청
        Mono<String> postResponse = webClient.post()
                                    .bodyValue(requestBody)
                                    .retrieve()
                                    .bodyToMono(String.class);
    }
}
