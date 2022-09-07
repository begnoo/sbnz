package domb.app.controllers;


import domb.app.dto.AddAnswerDTO;
import domb.app.dto.AddQuestionDTO;
import domb.app.model.facts.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import domb.app.model.facts.Question;
import domb.app.services.QuestionService;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Question read(@PathVariable Long id) {
        return questionService.read(id);
    }

    @PostMapping(path = "/addAnswer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Answer addAnswer(@RequestBody AddAnswerDTO answerDTO) {
        return questionService.addAnswer(answerDTO);
    }

    @PostMapping(path = "/addQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Question> addQuestion(@RequestBody AddQuestionDTO questionDTO) {
        return ResponseEntity.ok().body(questionService.addQuestion(questionDTO));
    }
}
