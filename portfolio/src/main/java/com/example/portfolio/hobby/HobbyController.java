package com.example.portfolio.hobby;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hobby", produces = MediaType.APPLICATION_JSON_VALUE)
public class HobbyController {

}
