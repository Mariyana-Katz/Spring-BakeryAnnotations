package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.services.BakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/baker")
public class BakerController {
    private BakerService service;

   @Autowired
   public BakerController(BakerService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<Baker> show(@RequestParam Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Baker> create(@RequestParam Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @GetMapping("/update")
    public ResponseEntity<Baker> update(@RequestParam Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @GetMapping("/destroy") public ResponseEntity<Boolean> destroy(@RequestParam Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
