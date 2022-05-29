package domb.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domb.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
}
