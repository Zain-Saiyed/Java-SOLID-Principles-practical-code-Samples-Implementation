package org.solid.Bad.SRP;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<QuestionQuiz> quizQuestions;
    private String quizName;
    private int score;

    public void loadQuestions() {
        this.quizName = "Class 11 Maths Chapter 9";
        this.quizQuestions = new ArrayList<>();
        // Questions Answer Reference: https://byjus.com/maths/class-11-maths-chapter-9-sequences-and-series-mcqs/
        quizQuestions.add(new QuestionQuiz("If a, 4, b are in Arithmetic Progression; a, 2, b are in Geometric Progression; then a, 1, b are in:","1","H.P","A.P","1"));
        quizQuestions.add(new QuestionQuiz("If a, b, c are in arithmetic progression, then:","2","2b = a+c","b = a+c","1"));
        quizQuestions.add(new QuestionQuiz("The sum of arithmetic progression 2, 5, 8, …, up to 50 terms is:","1","3775","3757","1"));
        quizQuestions.add(new QuestionQuiz("Which of the following is an example of a geometric sequence?","2","9, 20, 21, 28","1, 2, 4, 8","1"));
        quizQuestions.add(new QuestionQuiz("The next term of the given sequence 1, 5, 14, 30, 55, … is:","1","91","96","1"));
        System.out.println("Questions loaded successfully!");
    }

    public void displayQuestion() {
        Scanner input = new Scanner(System.in);
        for (QuestionQuiz QAObj  : quizQuestions) {
            System.out.println(QAObj.printQuestion());
            while (true) {
                System.out.println("Choose your option [1/2]:");
                String inputAnswer = input.nextLine();
                if (inputAnswer.equals("1") || inputAnswer.equals("2")) {
                    if (this.checkAnswer(inputAnswer,QAObj)) {
                        this.score++;
                    }
                    break;
                }
                else {
                    System.out.println("[**ERROR**] INVALID INPUT! PLEASE TRY AGAIN!");
                }
            }
        }
    }

    public boolean checkAnswer(String inputAnswer, QuestionQuiz QAObj) {
        if (inputAnswer.equals(QAObj.getAnswer())) {
            return true;
        }
        else
            return false;
    }

    public String getLetterGrade() {
        int value= this.generatePercentage();
        if (value >= 80) {
            return "A";
        } else if (value >= 70) {
            return "B";
        } else if (value >= 55) {
            return "C";
        } else if (value >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public int generatePercentage(){
        return (score*100/quizQuestions.size());
    }

    public void displayResult() {
        System.out.println("\n==== Congratulations! ====");
        System.out.println("Quiz completed Successfully! Here are the results: ");
        System.out.println("Total Questions    : "+quizQuestions.size());
        System.out.println("Correct Answers    : "+score);
        System.out.println("In Correct Answers : "+(quizQuestions.size()-score));
        System.out.println("Percentage obtained: "+this.generatePercentage());
        System.out.println("Letter Grade       : "+this.getLetterGrade());
    }

    public void saveResult(String userName) {
        FileWriter fileHandlerObj = null;
        try {
            fileHandlerObj = new FileWriter(userName+".txt");
            fileHandlerObj.write(java.time.LocalDate.now()+",Quiz Name:"+this.quizName+",Total Question:"+quizQuestions.size()+",Correct Answer:"+this.score+",Percentage:"+this.generatePercentage()+",Letter Grade:"+this.getLetterGrade()+"\n");
            fileHandlerObj.close();
            System.out.println("[**SUCCESS**] Quiz Result saved successfully!");
        } catch (IOException e) {
            System.out.println("[**ERROR**] ERROR SAVING RESULT! ERROR MESSAGE: "+e.getMessage());
        }
    }
}