package domb.app.services;

import domb.app.dto.AddAnswerDTO;
import domb.app.dto.AddQuestionDTO;
import domb.app.model.facts.Answer;
import domb.app.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domb.app.model.facts.Question;
import domb.app.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Question read(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Answer addAnswer(AddAnswerDTO answerDTO) {
        Optional<Question> question = questionRepository.findById(answerDTO.getQuestionId());
        Answer answer = new Answer();
        question.ifPresent(q -> {
            List<Answer> answers = q.getAnswers();
            answer.setAnswerText(answerDTO.getAnswerText());
            answers.add(answer);
            q.setAnswers(answers);

            questionRepository.save(q);
        });

        return answer;
    }

    public Question addQuestion(AddQuestionDTO questionDTO) {
        Optional<Answer> answer = answerRepository.findById(questionDTO.getAnswerId());
        if(answer.isPresent() && answer.get().getFollowUpQuestion() == null) {
            Question question = new Question();
            question.setQuestion(questionDTO.getQuestionText());
            answer.get().setFollowUpQuestion(question);

            Question retval = questionRepository.save(question);
            answerRepository.save(answer.get());
//            questionRepository.save(question);
            return retval;
        }
        return null;
    }
}
