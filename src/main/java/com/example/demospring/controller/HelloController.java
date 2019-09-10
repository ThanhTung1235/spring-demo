package com.example.demospring.controller;

import com.example.demospring.entity.Hero;
import com.example.demospring.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v_test/hero")
public class HelloController {
    @Autowired
    HeroRepository heroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Hero>> findAll() {
        try {
            List<Hero> heroList = heroRepository.findAll();
            return new ResponseEntity<>(heroList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Hero> store(@RequestBody Hero obj) {
        try {
            obj.setId(Calendar.getInstance().getTimeInMillis());
            heroRepository.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
