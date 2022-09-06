package domb.app.repositories;

import domb.app.model.facts.Answer;
import domb.app.model.facts.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
