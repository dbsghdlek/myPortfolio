package com.example.portfolio.domain.music.service.provider;

import com.example.portfolio.domain.music.service.MusicInfoProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class MusicInfoRestProvider implements MusicInfoProvider {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String musicInfo(String keyword) {
        StringBuilder stb = new StringBuilder("http://www.maniadb.com/api/search/");
        stb.append(keyword);
        stb.append("/?sr=artist&display=10&key=example&v=0.5");

        HttpEntity<String> entity = new HttpEntity(new HttpHeaders());
        ResponseEntity<String> exchange = restTemplate.exchange(stb.toString(), HttpMethod.GET, entity, String.class);

        if(HttpStatus.OK.equals(exchange.getStatusCode())){
            
            // XML에서 Item만 추출하여 JSON으로 추출
            JSONArray jsonArray = XML.toJSONObject(exchange.getBody())
                    .getJSONObject("rss")
                    .getJSONObject("channel")
                    .getJSONArray("item");

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String output;

            try {
                Object json = mapper.readValue(jsonArray.toString(), Object.class);
                output = mapper.writeValueAsString(json);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            return output;
        }else {
            throw new RuntimeException("Music Info Api connect failed");
        }
    }
}
