package ru.otus.spring.hw02.service;

import ru.otus.spring.hw02.dao.QuestionDao;
import ru.otus.spring.hw02.domain.Question;

import java.io.IOException;

public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getQuestions() throws IOException {
         return dao.findQuestions();
    }

    @Override
    public Question startTest() throws IOException {
        return dao.doTest();
    }
}
