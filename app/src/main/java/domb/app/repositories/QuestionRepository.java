package domb.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domb.app.model.facts.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
