package com.example.showcase.cars.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.example.showcase.cars.repository.CarRepository;
import com.example.showcase.entity.Car;

@SpringBootTest
@Transactional
class CarControllerTest {

    @Autowired
    CarController carController;
    @Autowired
    CarRepository carRepository;

    @Test
    void testFindEmptyCarList() {

        ResponseEntity<List<Car>> carsByName = carController.findCarsByName("");
        assertThat(carsByName.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Car> body = carsByName.getBody();

        assertThat(body).isNotNull().isEmpty();
    }
}