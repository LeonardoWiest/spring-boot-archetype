package com.github.leonardowiest.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "", consumes = { APPLICATION_JSON_VALUE, }, produces = { APPLICATION_JSON_VALUE, })
public interface UserController {

}
