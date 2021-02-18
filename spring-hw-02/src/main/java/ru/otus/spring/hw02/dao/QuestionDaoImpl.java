package ru.otus.spring.hw02.dao;
import ru.otus.spring.hw02.domain.Question;

import java.io.*;
import java.util.*;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;
    private final List<String> questions = new ArrayList<>();

    public QuestionDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Question findQuestions() throws IOException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
            byte[] b = new byte[input.available()];
            int i;
            while ((i = input.read()) != -1) {
                System.out.print((char) i);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file with questions doesn't exist in the specified directory!");
        }
        return new Question(fileName, questions);
    }

    @Override
    public Question doTest() throws IOException {
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line=reader.readLine()) != null){
            questions.add(line);}
            System.out.println(questions.get(0) +"\n" +questions.get(1)+"\n" +questions.get(2)+"\n" +questions.get(3));
            Scanner in = new Scanner(System.in);
            ArrayList <String> answers = new ArrayList(5);
            answers.add(in.nextLine());
            System.out.println(questions.get(5) +"\n" +questions.get(6)+"\n" +questions.get(7)+"\n" +questions.get(8));
            answers.add(in.nextLine());
            System.out.println(questions.get(10) +"\n" +questions.get(11)+"\n" +questions.get(12)+"\n" +questions.get(13));
            answers.add(in.nextLine());
            System.out.println(questions.get(15) +"\n" +questions.get(16)+"\n" +questions.get(17)+"\n" +questions.get(18));
            answers.add(in.nextLine());
            System.out.println(questions.get(20) +"\n" +questions.get(21)+"\n" +questions.get(22)+"\n" +questions.get(23));
            answers.add(in.nextLine());
            System.out.println("The test is over!");
            InputStream input2 = getClass().getClassLoader().getResourceAsStream("answers.csv");
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(input2));
            String line2;
            ArrayList <String> right = new ArrayList(5);
            while((line2=reader2.readLine()) != null){
            right.add(line2);}
            int count = 0;
            for (int i = 0; i < right.size(); i++) {
                if (right.get(i).equals(answers.get(i)))
                { count++; }
            }
            System.out.println("Your score for the test: " + count );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return new Question(fileName, questions);
    }
}