package org.solid.Good.SRP;

import java.util.List;
import java.util.Scanner;

public class QuizManager {
    private int score;
    QuizEvaluator quizEval;

    public QuizManager () {
        quizEval = new QuizEvaluator();
    }
    public QuizEvaluator getQuizEval() {
        return quizEval;
    }

    public int getScore() {
        return score;
    }

    public void displayQuizQuestion(List<questionQuiz> quizQuestions) {
        Scanner input = new Scanner(System.in);
        for (questionQuiz QAObj  : quizQuestions) {
            System.out.println("Question : "+ QAObj.getQuestion());
            System.out.println("Option 1 : "+ QAObj.getOption1());
            System.out.println("Option 2 : "+ QAObj.getOption2());
            while (true) {
                System.out.println("Choose your option [1/2]:");
                String inputAnswer = input.nextLine();
                if (inputAnswer.equals("1") || inputAnswer.equals("2")) {
                    this.score = quizEval.calculateScore(this.score,inputAnswer, QAObj.getAnswer());
                    break;
                }
                else {
                    System.out.println("[**ERROR**] INVALID INPUT! PLEASE TRY AGAIN!");
                }
            }
        }
    }

    public void displayResult(List<questionQuiz> quizQuestions) {
        System.out.println("Congratulations!");
        System.out.println("Quiz completed Successfully! Here are the results: ");
        System.out.println("Total Questions    : "+quizQuestions.size());
        System.out.println("Correct Answers    : "+this.score);
        System.out.println("In Correct Answers : "+(quizQuestions.size()-this.score));
        System.out.println("Percentage obtained: "+quizEval.generatePercentage(this.score, quizQuestions.size()));
        System.out.println("Letter Grade       : "+quizEval.getLetterGrade(this.score,quizQuestions.size()));
    }
}