package org.solid.Good.SRP;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=====================================================================================================================");
        System.out.println("SRP : Quiz application scenario where quiz class is split across multipel clas having separate single responsibilities");
        System.out.println("======================================================================================================================");
        System.out.println("*** Adhering Single Responsibility Principle");

        QuizLoadData quizDataLoader = new QuizLoadData();
        // Creating a Quiz object
        QuizManager quizManager = new QuizManager();
        // Initiate Quiz by passing the Quiz questions from the quizDataLoader to the Quiz Manager
        quizManager.displayQuizQuestion(quizDataLoader.loadQuestions());
        System.out.println("==== Quiz Completed Successfully! ====");
        // Displaying Quiz Result given by User
        quizManager.displayResult(quizDataLoader.getQuizQuestions());
        // Saving user's result into file
        System.out.println("\n==== Saving Quiz Result to file ====");
        QuizEvaluator quizEvaluator =  quizManager.getQuizEval();
        QuizSaveResultsToDisk.saveResult("Mark Wood",quizDataLoader.getQuizName(),quizEvaluator.getLetterGrade(),quizEvaluator.getPercentage(),quizDataLoader.getQuizQuestions().size(),quizManager.getScore());
    }
}