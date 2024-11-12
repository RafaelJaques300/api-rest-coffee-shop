package com.desafio.api_rest_coffee_shop.repositories;

import com.desafio.api_rest_coffee_shop.models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeRepository extends JpaRepository<Coffee,Long> {
}
