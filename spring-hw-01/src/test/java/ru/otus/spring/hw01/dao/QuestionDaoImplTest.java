package ru.otus.spring.hw01.dao;
;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
class QuestionDaoImplTest {


    @Test
    @DisplayName("If fileName is null, then NullPointerException")
    void findQuestions() throws NullPointerException {

        QuestionDaoImpl que = new QuestionDaoImpl(null);
        Throwable thrown = assertThrows(NullPointerException.class, que::findQuestions);

    }

}
