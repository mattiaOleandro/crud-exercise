package co.develhope.crudexercise.controllers;

import co.develhope.crudexercise.entities.Car;
import co.develhope.crudexercise.repositories.I_CarRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private I_CarRepository i_carRepository;

    @PostMapping("/postCar")
    public String postCar(@RequestBody Car car){
        return "New car created!\n" + i_carRepository.save(car).toString();
    }

    @GetMapping("/getAllCars")
    public List<Car> getALlCars() {
        return i_carRepository.findAll();
    }

    @GetMapping("/getCar/{id}")
    public Optional<Car> getCar(@PathVariable Long id) {
        if (i_carRepository.existsById(id)) {
            return i_carRepository.findById(id);
        }else {
            return null;
        }
    }

    @PutMapping("/putCar/{id}")
    public Car putCar(@PathVariable Long id, @RequestBody Car car){
        if(i_carRepository.existsById(id)){
            car.setId(id);
            i_carRepository.save(car);
            return car;
        }else{
            return null;
        }
    }

    @DeleteMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable Long id, HttpServletResponse response) {
        if(i_carRepository.existsById(id)) {
            i_carRepository.deleteById(id);
            return "Car " + id + " has been eliminated!";
        }else{
            try {
                response.sendError(409, "Conflict");
            }catch (IOException e){
                e.getMessage();
            }
            return null;
        }
    }

    @DeleteMapping("/deleteAllCar")
    public String deleteAllCar(){
        i_carRepository.deleteAll();
        return "All cars have been eliminated!";
    }
}
