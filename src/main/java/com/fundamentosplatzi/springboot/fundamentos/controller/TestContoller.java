package com.fundamentosplatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestContoller {
    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> funtion(){
        return  new ResponseEntity<>("HELLO CONTROLLER update update", HttpStatus.OK);
    }

}
