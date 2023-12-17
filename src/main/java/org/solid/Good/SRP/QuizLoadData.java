package org.solid.Good.SRP;

import java.util.ArrayList;
import java.util.List;

public class QuizLoadData {

    private String quizName;
    private ArrayList<questionQuiz> quizQuestions;

    public ArrayList<questionQuiz> getQuizQuestions() {
        return quizQuestions;
    }

    public String getQuizName() {
        return quizName;
    }
    public List<questionQuiz> loadQuestions() {
        this.quizName = "Class 11 Maths Chapter 9";
        this.quizQuestions = new ArrayList<>();
        // Questions Answer Reference: https://byjus.com/maths/class-11-maths-chapter-9-sequences-and-series-mcqs/
        quizQuestions.add(new questionQuiz("If a, 4, b are in Arithmetic Progression; a, 2, b are in Geometric Progression; then a, 1, b are in:","1","H.P","A.P","1"));
        quizQuestions.add(new questionQuiz("If a, b, c are in arithmetic progression, then:","2","2b = a+c","b = a+c","1"));
        quizQuestions.add(new questionQuiz("The sum of arithmetic progression 2, 5, 8, …, up to 50 terms is:","1","3775","3757","1"));
        quizQuestions.add(new questionQuiz("Which of the following is an example of a geometric sequence?","2","9, 20, 21, 28","1, 2, 4, 8","1"));
        quizQuestions.add(new questionQuiz("The next term of the given sequence 1, 5, 14, 30, 55, … is:","1","91","96","1"));

        System.out.println("Questions loaded successfully!");
        return quizQuestions;
    }
}