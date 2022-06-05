package domb.app.repositories;

import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import domb.app.model.Instructions;
import domb.app.model.enums.PartEnum;

public interface InstructionsRepository extends JpaRepository<Instructions, Long> {
    Optional<Instructions> findByPart(PartEnum part);
}
