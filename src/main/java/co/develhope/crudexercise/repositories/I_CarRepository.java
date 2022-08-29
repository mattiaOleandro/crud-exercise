package co.develhope.crudexercise.repositories;

import co.develhope.crudexercise.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_CarRepository extends JpaRepository<Car, Long> {
}
