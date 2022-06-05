package domb.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.facts.Question;
import domb.app.repositories.QuestionRepository;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question read(Long id) {
        return questionRepository.findById(id).orElse(null);
    }
}
