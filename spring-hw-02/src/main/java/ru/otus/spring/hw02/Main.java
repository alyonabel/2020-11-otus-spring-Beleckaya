package ru.otus.spring.hw02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.otus.spring.hw02.domain.Question;
import ru.otus.spring.hw02.service.QuestionService;

import java.io.IOException;
import java.util.Scanner;

@Configuration
@ComponentScan ("ru.otus.spring.hw02")
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("\nHello! Let's start the test!\nPlease introduce yourself! Input your name and press Enter\n");
        String str = in.nextLine();

        System.out.println("\nHello " + str +"!" +"\n Input the number of answer and press Enter\n Good luck!\n");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        Question all = service.startTest();
        System.out.println("The questions for the test:" + all.toString());

        context.close();
    }
}