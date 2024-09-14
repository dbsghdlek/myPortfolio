package com.example.portfolio.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/admin", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@Slf4j
public class UserAdminController {


}
