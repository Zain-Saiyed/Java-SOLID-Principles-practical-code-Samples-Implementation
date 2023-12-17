package org.solid.Bad.SRP;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n====================================================================================================================");
        System.out.println("SRP : Quiz application scenario where quiz class does answer evaluation, input tasks, and saving quiz result to file");
        System.out.println("====================================================================================================================");
        System.out.println("*** Failing Single Responsibility Principle");

        // Creating a Quiz object
        Quiz quiz = new Quiz();
        // Loading the Quiz questions inside the Quiz object
        quiz.loadQuestions();
        // Giving quiz question's answers
        quiz.displayQuestion();
        System.out.println("==== Quiz Completed Successfully! ====");
        // Displaying Quiz Result given by User
        quiz.displayResult();
        // Saving user's result into file
        System.out.println("\n==== Saving Quiz Result to file ====");
        quiz.saveResult("Mark Wood");
    }
}
