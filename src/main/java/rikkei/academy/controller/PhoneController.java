package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.model.SmartPhone;
import rikkei.academy.service.smart_phone.ISmartPhoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping
    public ResponseEntity<?> allPhones() {
        List<SmartPhone> phones = (List<SmartPhone>) smartPhoneService.findAll();
        if (phones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Optional<SmartPhone> smartPhoneOptional) {
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhoneOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id")
            Optional<SmartPhone> smartPhoneOptional,
            @RequestBody
            SmartPhone smartPhone
    ) {
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhone.setId(smartPhoneOptional.get().getId());
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable("id") Optional<SmartPhone> smartPhoneOptional
    ) {
        if (!smartPhoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(smartPhoneOptional.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
