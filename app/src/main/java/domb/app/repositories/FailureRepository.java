package domb.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domb.app.model.vehicle.Failure;

@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
    
}
