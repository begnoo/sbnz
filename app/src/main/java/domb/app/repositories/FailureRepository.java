package domb.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domb.app.model.vehicle.Failure;

@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
    Optional<List<Failure>> findByVehicleManufacturerAndVehicleModel(String manufacturer, String model);
}
