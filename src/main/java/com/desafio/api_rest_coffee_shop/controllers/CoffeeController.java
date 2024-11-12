package com.desafio.api_rest_coffee_shop.controllers;

import com.desafio.api_rest_coffee_shop.models.Coffee;
import com.desafio.api_rest_coffee_shop.repositories.CoffeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffe")
public class CoffeeController {

    @Autowired
    CoffeRepository coffeRepository;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> gettAllCoffee() {
        return coffeRepository.findAll();
    }

    @PostMapping(value = "/createCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee createNewCoffee(@RequestBody Coffee coffee) {

        Coffee createCoffee = new Coffee();

        createCoffee.setName(coffee.getName());
        createCoffee.setPrice(coffee.getPrice());

        return coffeRepository.save(createCoffee);

    }

    @PutMapping(value = "updatedCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updatedCoffe(@RequestBody Coffee coffee) {
        Coffee getCoffee = coffeRepository.findById(coffee.getId()).orElseThrow();

        Coffee updatedCoffee = new Coffee();

        updatedCoffee.setId(coffee.getId());
        updatedCoffee.setName(coffee.getName());
        updatedCoffee.setPrice(coffee.getPrice());

        return coffeRepository.save(updatedCoffee);
    }

    @DeleteMapping(value = "/deleteCoffee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Coffee deleteCoffe(@PathVariable Long id) {
        Coffee getCoffee = coffeRepository.findById(id).orElseThrow();
        coffeRepository.delete(getCoffee);
        return getCoffee;
    }
}


